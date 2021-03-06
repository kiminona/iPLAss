/*
 * Copyright 2013 INFORMATION SERVICES INTERNATIONAL - DENTSU, LTD. All Rights Reserved.
 */

package org.iplass.mtp.tools.batch.pack;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.iplass.mtp.ManagerLocator;
import org.iplass.mtp.SystemException;
import org.iplass.mtp.auth.User;
import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.entity.EntityManager;
import org.iplass.mtp.impl.core.ExecuteContext;
import org.iplass.mtp.impl.core.TenantContext;
import org.iplass.mtp.impl.core.TenantContextService;
import org.iplass.mtp.impl.entity.EntityService;
import org.iplass.mtp.impl.metadata.MetaDataContext;
import org.iplass.mtp.impl.metadata.MetaDataEntry;
import org.iplass.mtp.impl.metadata.MetaDataEntry.RepositoryType;
import org.iplass.mtp.impl.metadata.MetaDataEntryInfo;
import org.iplass.mtp.impl.tenant.TenantService;
import org.iplass.mtp.impl.tools.metaport.MetaDataPortingService;
import org.iplass.mtp.impl.tools.pack.PackageCreateCondition;
import org.iplass.mtp.impl.tools.pack.PackageCreateResult;
import org.iplass.mtp.impl.tools.pack.PackageEntity;
import org.iplass.mtp.impl.tools.pack.PackageService;
import org.iplass.mtp.impl.web.WebFrontendService;
import org.iplass.mtp.spi.ServiceRegistry;
import org.iplass.mtp.tenant.Tenant;
import org.iplass.mtp.tools.ToolsBatchResourceBundleUtil;
import org.iplass.mtp.tools.batch.ExecMode;
import org.iplass.mtp.tools.batch.MtpCuiBase;
import org.iplass.mtp.transaction.Transaction;
import org.iplass.mtp.util.StringUtil;


/**
 * Package Export Batch
 */
public class PackageExport extends MtpCuiBase {

	//実行モード
	private ExecMode execMode = ExecMode.WIZARD;

	private TenantService ts = ServiceRegistry.getRegistry().getService(TenantService.class);
	private TenantContextService tcs = ServiceRegistry.getRegistry().getService(TenantContextService.class);
	private PackageService ps = ServiceRegistry.getRegistry().getService(PackageService.class);
	private MetaDataPortingService mdps = ServiceRegistry.getRegistry().getService(MetaDataPortingService.class);
	private EntityService ehs = ServiceRegistry.getRegistry().getService(EntityService.class);

	/**
	 * args[0]・・・execMode
	 * args[1]・・・language
	 **/
	public static void main(String[] args) {

		PackageExport instance = null;
		try {
			instance = new PackageExport(args);
			instance.execute();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			ExecuteContext.finContext();
		}
	}

	/**
	 * args[0]・・・execMode
	 * args[1]・・・language
	 **/
	public PackageExport(String... args) {

		if (args != null) {
			if (args.length > 0) {
				setExecMode(ExecMode.valueOf(args[0]));
			}
			if (args.length > 1) {
				//systemの場合は、JVMのデフォルトを利用
				if (!"system".equals(args[1])) {
					setLanguage(args[1]);
				}
			}
		}

		setupLanguage();
	}

	/**
	 * モードに合わせて実行します。
	 *
	 * @return
	 */
	public boolean execute() {

		clearLog();

		//Console出力用のログリスナーを生成
		LogListner consoleLogListner = getConsoleLogListner();
		addLogListner(consoleLogListner);

		//環境情報出力
		logEnvironment();

		switch (getExecMode()) {
		case WIZARD :
			logInfo("■Start Export Wizard");
			logInfo("");

			//Wizardの実行
			return startExportWizard();
		case SILENT :
			//TODO Silent版
			logInfo("■Start Export Silent");
			logInfo("");

			return false;
		default :
			logError("unsupport execute mode : " + getExecMode());
			return false;
		}

	}

	public ExecMode getExecMode() {
		return execMode;
	}

	public void setExecMode(ExecMode execMode) {
		this.execMode = execMode;
	}

	/**
	 * Exportします。
	 *
	 * @param param Export情報
	 * @return
	 */
	public boolean executeExport(final PackageExportParameter param) {

		setSuccess(false);

		try {
			boolean isSuccess = Transaction.required(t -> {

				//外部から直接呼び出された場合を考慮し、Pathを取得
				if (param.isExportMetaData() && param.getExportMetaDataPathList() == null) {
					getMetaDataPathList(param);
				}

				//外部から直接呼び出された場合を考慮し、Pathを取得
				if (param.isExportEntityData() && param.getExportEntityDataPathList() == null) {
					getEntityDataPathList(param);
				}

				TenantContext tContext = tcs.getTenantContext(param.getTenantId());

				return ExecuteContext.executeAs(tContext, () -> {
					ExecuteContext.getCurrentContext().setLanguage(getLanguage());

					//PackageCreateConditionの生成
					final PackageCreateCondition cond = new PackageCreateCondition();
					cond.setName(param.getPackageName());
					cond.setMetaDataPaths(param.getExportMetaDataPathList());
					cond.setEntityPaths(param.getExportEntityDataPathList());

					List<String> messageSummary = new ArrayList<>();

					//Package情報を登録(別トランザクションにしないとCreatePackage処理でエラーになる。別トランザクションなので)
					final String oid = Transaction.requiresNew(tt -> {
						return ps.storePackage(cond, PackageEntity.TYPE_OFFLINE);
					});

					String infoMsg = rs("PackageExport.createdPackageInfoLog", oid );
					logInfo(infoMsg);
					messageSummary.add(infoMsg);

					//Package作成処理
					logInfo(rs("PackageExport.startExportPackageLog"));
					final PackageCreateResult result = Transaction.requiresNew(tt -> {
						return ps.archivePackage(oid, getTempDir(param));
					});
					if (result.isError()) {
						if (result.getMessages() != null) {
							for (String message : result.getMessages()) {
								logError(message);
							}
							logInfo("");
						}

						logError(getCommonResourceMessage("errorMsg", ""));
						return false;
					}

					if (result.getMessages() != null) {
						for (String message : result.getMessages()) {
							logInfo(message);
							messageSummary.add(message);
						}
						logInfo("");
					}

					//zip作成処理(別トランザクションにしないとArchiveが取得できない。Package作成が別トランザクションなので)
					String fileName = Transaction.requiresNew(tt -> {
						return createExportFile(param, oid);
					});

					logInfo("-----------------------------------------------------------");
					logInfo("■Execute Result Summary");
					for(String message : messageSummary) {
						logInfo(message);
					}
					logInfo("-----------------------------------------------------------");
					logInfo("");

					logInfo(rs("PackageExport.completedExportPackageLog", fileName));

					return true;
				});

			});

			setSuccess(isSuccess);

		} catch (Throwable e) {
			logError(getCommonResourceMessage("errorMsg", e.getMessage()));
		} finally {
			logInfo("");
			logInfo("■Execute Result :" + (isSuccess() ? "SUCCESS" : "FAILED"));
			logInfo("");
		}

		return isSuccess();
	}

	/**
	 * PackageExport情報を出力します。
	 */
	public void logArguments(final PackageExportParameter param) {
		logInfo("-----------------------------------------------------------");
		logInfo("■Execute Argument");
		logInfo("\ttenant name :" + param.getTenantName());
		logInfo("\texport metadata :" + param.isExportMetaData());
		if (param.isExportMetaData()) {
			String metaTarget = null;
			if (param.isExportAllMetaData()) {
				metaTarget = "ALL";
				if (param.isExportTenantMetaData()) {
					metaTarget += "(include Tenant)";
				} else {
					metaTarget += "(exclude Tenant)";
				}
			} else {
				metaTarget = param.getExportMetaDataPathStr();
			}
			metaTarget += "(" + param.getExportMetaDataPathList().size() + ")";

			logInfo("\tmetadata target :" + metaTarget);
		}
		logInfo("\texport entity data :" + param.isExportEntityData());
		if (param.isExportEntityData()) {
			String entityTarget = null;
			if (param.isExportAllEntityData()) {
				entityTarget = "ALL";
				if (param.isExportUserEntityData()) {
					entityTarget += "(include User)";
				} else {
					entityTarget += "(exclude User)";
				}
			} else {
				entityTarget = param.getExportEntityDataPathStr();
			}
			entityTarget += "(" + param.getExportEntityDataPathList().size() + ")";

			logInfo("\tentity target :" + entityTarget);
		}
		logInfo("-----------------------------------------------------------");
		logInfo("");
	}


	/**
	 * Export対象のメタデータパスを設定します。
	 * @param param
	 */
	private void getMetaDataPathList(final PackageExportParameter param) {

		if (!param.isExportMetaData()) {
			return;
		}

		TenantContext tContext = tcs.getTenantContext(param.getTenantId());
		ExecuteContext.executeAs(tContext, ()-> {
			ExecuteContext.getCurrentContext().setLanguage(getLanguage());

			List<String> paths = new ArrayList<>();
			if (param.isExportAllMetaData()) {
				List<MetaDataEntryInfo> allMeta = MetaDataContext.getContext().definitionList("/");
				for (MetaDataEntryInfo info : allMeta) {
					if (param.isExportLocalMetaDataOnly()) {
						if (info.getRepositryType() != RepositoryType.TENANT_LOCAL) {
							continue;
						}
					}
					if (!param.isExportTenantMetaData()) {
						if (mdps.isTenantMeta(info.getPath())) {
							continue;
						}
					}
					paths.add(info.getPath());
				}
			} else {
				//個別指定

				Set<String> directPathSet = new HashSet<>();	//重複を避けるためSetに保持

				String[] pathStrArray = param.getExportMetaDataPathStr().split(",");
				for (String pathStr : pathStrArray) {
					//,,などの阻止
					if (StringUtil.isEmpty(pathStr)) {
						continue;
					}

					if (pathStr.endsWith("*")) {
						//アスタリスク指定
						List<MetaDataEntryInfo> allMeta = MetaDataContext.getContext().definitionList(pathStr.substring(0, pathStr.length() - 1));
						for (MetaDataEntryInfo info : allMeta) {
							if (param.isExportLocalMetaDataOnly()) {
								if (info.getRepositryType() != RepositoryType.TENANT_LOCAL) {
									continue;
								}
							}
							directPathSet.add(info.getPath());
						}
					} else {
						//直接指定
						MetaDataEntry entry = MetaDataContext.getContext().getMetaDataEntry(pathStr);
						if (entry != null) {
							if (param.isExportLocalMetaDataOnly()) {
								if (entry.getRepositryType() != RepositoryType.TENANT_LOCAL) {
									logWarn(rs("PackageExport.excludeNotLocalMetaLog", pathStr));
									continue;
								}
							}
							directPathSet.add(entry.getPath());
						} else {
							logWarn(rs("PackageExport.notFoundMetaLog", pathStr));
							continue;
						}
					}
				}
				paths.addAll(directPathSet);
			}

			//ソートしてセット
			param.setExportMetaDataPathList(paths.stream().sorted().collect(Collectors.toList()));

			return null;
		});
	}

	/**
	 * Export対象のメタデータパスを出力します。
	 * @param param
	 */
	private void showMetaDataPathList(final PackageExportParameter param) {

		logInfo("-----------------------------------------------------------");
		logInfo("■MetaData List");
		for (String path : param.getExportMetaDataPathList()) {
			logInfo(path);
		}
		logInfo("-----------------------------------------------------------");
	}

	/**
	 * Export対象のEntityデータパスを設定します。
	 * @param param
	 */
	private void getEntityDataPathList(final PackageExportParameter param) {

		if (!param.isExportEntityData()) {
			return;
		}

		TenantContext tContext = tcs.getTenantContext(param.getTenantId());
		ExecuteContext.executeAs(tContext, ()-> {
			ExecuteContext.getCurrentContext().setLanguage(getLanguage());

			List<String> paths = new ArrayList<>();

			List<MetaDataEntryInfo> entityList = ehs.list();

			if (param.isExportAllEntityData()) {
				for (MetaDataEntryInfo info : entityList) {
					if (!param.isExportUserEntityData()) {
						if (info.getPath().equals(EntityService.getFixedPath() + User.DEFINITION_NAME)) {
							continue;
						}
					}
					paths.add(info.getPath());
				}
			} else {
				//個別指定

				Set<String> directPathSet = new HashSet<>();	//重複を避けるためSetに保持

				String[] pathStrArray = param.getExportEntityDataPathStr().split(",");
				for (String pathStr : pathStrArray) {
					//,,などの阻止
					if (StringUtil.isEmpty(pathStr)) {
						continue;
					}

					boolean isFound = false;
					if (pathStr.endsWith("*")) {
						//アスタリスク指定
						String prefixPath = null;
						if (pathStr.equals("*")) {
							prefixPath = "";
						} else {
							prefixPath = pathStr.substring(0, pathStr.length() - 1).replace(".", "/");
						}
						for (MetaDataEntryInfo info : entityList) {
							if (!info.getPath().startsWith(EntityService.getFixedPath() + prefixPath)) {
								continue;
							}
							isFound = true;
							directPathSet.add(info.getPath());
						}
					} else {
						//直接指定
						for (MetaDataEntryInfo info : entityList) {
							if (info.getPath().equals(EntityService.getFixedPath() + pathStr)) {
								directPathSet.add(info.getPath());
								isFound = true;
								break;
							}
						}
					}
					if (!isFound) {
						logWarn(rs("PackageExport.notFoundEntityLog", pathStr));
						continue;
					}
				}
				paths.addAll(directPathSet);
			}

			//ソートしてセット
			param.setExportEntityDataPathList(paths.stream().sorted().collect(Collectors.toList()));

			return null;
		});

	}

	/**
	 * Export対象のEntityデータパスを出力します。
	 * @param param
	 */
	private void showEntityDataPathList(final PackageExportParameter param) {

		logInfo("-----------------------------------------------------------");
		logInfo("■EntityData List");
		for (String path : param.getExportEntityDataPathList()) {
			logInfo(path);
		}
		logInfo("-----------------------------------------------------------");
	}

	private String createExportFile(final PackageExportParameter param, final String oid) {

		//Entityの取得
		EntityManager em = ManagerLocator.getInstance().getManager(EntityManager.class);
		Entity entity = em.load(oid, PackageEntity.ENTITY_DEFINITION_NAME);
		if (entity == null) {
			throw new SystemException(rs("PackageExport.notFoundPackageInfoLog", oid));
		}

		//Fileの取得
		BinaryReference binaryReference = entity.getValue(PackageEntity.ARCHIVE);
		if (binaryReference == null) {
			throw new SystemException(rs("PackageExport.notFoundPackageInfoLog", oid));
		}
		InputStream is = null;
		OutputStream os = null;
		String fileName = null;
		try {
			is = em.getInputStream(binaryReference);
			if (is == null) {
				throw new SystemException(rs("PackageExport.notFoundPackageInfoLog", oid));
			}

			File file = new File(param.getExportDir(), param.getPackageName() + ".zip");
			os = new FileOutputStream(file);
			fileName = file.getAbsolutePath();

			//出力
			IOUtils.copy(is, os);

		} catch (UnsupportedEncodingException e) {
            throw new SystemException(e);
		} catch (IOException e) {
            throw new SystemException(e);
		} finally {
			try {
				if (is != null) {
					is.close();
					is = null;
				}
			} catch (IOException e) {
	            throw new SystemException(e);
			} finally {
				try {
					if (os != null) {
						os.close();
						os = null;
					}
				} catch (IOException e) {
		            throw new SystemException(e);
				}
			}
		}
		return fileName;
	}

	/**
	 * Export用のパラメータを生成して、Export処理を実行します。
	 *
	 * @return
	 */
	private boolean startExportWizard() {

		//テナントURL
		String tenantUrl = readConsole(getCommonResourceMessage("inputTenantUrlMsg"));

		if (StringUtil.isEmpty(tenantUrl)) {
			logWarn(getCommonResourceMessage("requiredTenantUrlMsg"));
			return startExportWizard();
		}
		if (tenantUrl.equalsIgnoreCase("-show")) {
			//一覧を出力
			showValidTenantList();
			return startExportWizard();
		}
		if (tenantUrl.equalsIgnoreCase("-env")) {
			//環境情報を出力
			logEnvironment();
			return startExportWizard();
		}

		//URL存在チェック
		String key = tenantUrl.startsWith("/") ? tenantUrl : "/" + tenantUrl;
		Tenant tenant = ts.getTenant(key);
		if (tenant == null) {
			logWarn(getCommonResourceMessage("notExistsTenantMsg", key));
			return startExportWizard();
		}

		PackageExportParameter param = new PackageExportParameter(tenant.getId(), tenant.getName());

		//出力先ディレクトリ
		boolean validFile = false;
		do {
			String exportDirName = readConsole(rs("PackageExport.Wizard.inputDirMsg") + "(" + param.getExportDirName() + ")");
			if (StringUtil.isNotBlank(exportDirName)) {
				param.setExportDirName(exportDirName);
			}

			//チェック
			File exportDir = new File(param.getExportDirName());
			if (!exportDir.exists()) {
				exportDir.mkdir();
				logInfo(rs("PackageExport.Wizard.createdInputDirMsg", param.getExportDirName()));
			}
			if (!exportDir.isDirectory()) {
				logWarn(rs("PackageExport.Wizard.notDirMsg", param.getExportDirName()));
			} else {
				param.setExportDir(exportDir);
				validFile = true;
			}
		} while(validFile == false);

		//Package名
		String packageName = readConsole(rs("PackageExport.Wizard.inputPackageNameMsg") + "(" + param.getPackageName() + ")");
		if (StringUtil.isNotBlank(packageName)) {
			param.setPackageName(packageName);
		}

		boolean validTarget = false;
		do {
			//メタデータExport
			boolean validMetaData = false;
			do {
				boolean isExportMeta = readConsoleBoolean(rs("PackageExport.Wizard.confirmExportMetaMsg"), param.isExportMetaData());
				param.setExportMetaData(isExportMeta);
				if (isExportMeta) {

					boolean isExportLocalOnly = readConsoleBoolean(rs("PackageExport.Wizard.confirmTargetLocalMetaMsg"), param.isExportLocalMetaDataOnly());
					param.setExportLocalMetaDataOnly(isExportLocalOnly);

					boolean isExportAllMeta = readConsoleBoolean(rs("PackageExport.Wizard.confirmExportAllMetaMsg"), param.isExportAllMetaData());
					param.setExportAllMetaData(isExportAllMeta);
					if (isExportAllMeta) {
						//全メタデータ出力

						//テナントを含めるかを確認
						boolean isExportTenantMetaData = readConsoleBoolean(rs("PackageExport.Wizard.confirmIncludeTenantMetaMsg"), param.isExportTenantMetaData());
						param.setExportTenantMetaData(isExportTenantMetaData);

						validMetaData = true;
					} else {
						//個別指定
						String exportMetaDataPathStr = readConsole(rs("PackageExport.Wizard.inputMetaPathMsg"));
						if (StringUtil.isEmpty(exportMetaDataPathStr)) {
							//未指定なのでContinue
							logWarn(rs("PackageExport.Wizard.requiredMetaPathMsg"));
							logInfo("");
						} else {
							param.setExportMetaDataPathStr(exportMetaDataPathStr);
							validMetaData = true;
						}
					}

					if (validMetaData) {
						//Pathの取得
						getMetaDataPathList(param);
						boolean isShow = readConsoleBoolean(rs("PackageExport.Wizard.confirmShowMetaListMsg", param.getExportMetaDataPathList().size()), false);
						if (isShow) {
							showMetaDataPathList(param);
						}
						boolean isContinue = readConsoleBoolean(getCommonResourceMessage("continueMsg"), true);
						if (!isContinue) {
							validMetaData = false;
						}
					}

				} else {
					//Exportしない
					validMetaData = true;
				}
			} while(validMetaData == false);


			//EntityデータExport
			boolean validEntityData = false;
			do {
				boolean isExportEntity = readConsoleBoolean(rs("PackageExport.Wizard.confirmExportEntityMsg"), param.isExportEntityData());
				param.setExportEntityData(isExportEntity);
				if (isExportEntity) {

					boolean isExportAllEntity = readConsoleBoolean(rs("PackageExport.Wizard.confirmExportAllEntityMsg"), param.isExportAllEntityData());
					param.setExportAllEntityData(isExportAllEntity);
					if (isExportAllEntity) {
						//全Entityデータ出力

						//Userを含めるかを確認
						boolean isExportUserEntityData = readConsoleBoolean(rs("PackageExport.Wizard.confirmIncludeUserEntityMsg"), param.isExportUserEntityData());
						param.setExportUserEntityData(isExportUserEntityData);

						validEntityData = true;
					} else {
						//個別指定
						String exportEntityPathStr = readConsole(rs("PackageExport.Wizard.inputEntityPathMsg"));
						if (StringUtil.isEmpty(exportEntityPathStr)) {
							//未指定なのでContinue
							logWarn(rs("PackageExport.Wizard.requiredEntityPathMsg"));
							logInfo("");
						} else {
							param.setExportEntityDataPathStr(exportEntityPathStr);
							validEntityData = true;
						}
					}

					if (validEntityData) {
						//Pathの取得
						getEntityDataPathList(param);
						boolean isShow = readConsoleBoolean(rs("PackageExport.Wizard.confirmShowEntityListMsg", param.getExportEntityDataPathList().size()), false);
						if (isShow) {
							showEntityDataPathList(param);
						}
						boolean isContinue = readConsoleBoolean(getCommonResourceMessage("continueMsg"), true);
						if (!isContinue) {
							validEntityData = false;
						}
					}

				} else {
					//Exportしない
					validEntityData = true;
				}
			} while(validEntityData == false);

			//Export対象が含まれるかのチェック
			if (!param.isExportMetaData() && !param.isExportEntityData()) {
				//Export対象なし
				logWarn(rs("PackageExport.Wizard.targetEmptyMsg"));
				logInfo("");
			} else {
				validTarget = true;
			}

		} while(validTarget == false);

		boolean validExecute = false;
		do {
			//実行情報出力
			logArguments(param);

			boolean isExecute = readConsoleBoolean(rs("PackageExport.Wizard.confirmExportPackageMsg"), false);
			if (isExecute) {
				validExecute = true;
			} else {
				//defaultがfalseなので念のため再度確認
				isExecute = readConsoleBoolean(rs("PackageExport.Wizard.confirmRetryMsg"), true);

				if (isExecute) {
					//再度実行
					return startExportWizard();
				}
			}
		} while(validExecute == false);

		//ConsoleのLogListnerを一度削除してLog出力に切り替え
		LogListner consoleLogListner = getConsoleLogListner();
		removeLogListner(consoleLogListner);
		LogListner loggingListner = getLoggingLogListner();
		addLogListner(loggingListner);

		//Export処理実行
		boolean ret = executeExport(param);

		//LogListnerを一度削除
		removeLogListner(loggingListner);

		return ret;
	}

	private File getTempDir(final PackageExportParameter param) {
		//TODO BatchのTempディレクトリもWebFrontendServiceを見ていいか？
		WebFrontendService webFront = ServiceRegistry.getRegistry().getService(WebFrontendService.class);
		File tempDir = null;
		if (webFront.getTempFileDir() == null) {
			//未指定の場合は、作成先ディレクトリを利用
			tempDir = param.getExportDir();
		} else {
			tempDir = new File(webFront.getTempFileDir());
		}
		return tempDir;
	}

	private String rs(String key, Object... args) {
		return ToolsBatchResourceBundleUtil.resourceString(getLanguage(), key, args);
	}

}

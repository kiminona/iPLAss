/*
 * Copyright (C) 2012 INFORMATION SERVICES INTERNATIONAL - DENTSU, LTD. All Rights Reserved.
 *
 * Unless you have purchased a commercial license,
 * the following license terms apply:
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package org.iplass.adminconsole.client.metadata.ui.top.item;

import java.util.LinkedHashMap;

import org.iplass.adminconsole.client.base.event.MTPEvent;
import org.iplass.adminconsole.client.base.i18n.AdminClientMessageUtil;
import org.iplass.adminconsole.client.base.tenant.TenantInfoHolder;
import org.iplass.adminconsole.client.base.ui.widget.AbstractWindow;
import org.iplass.adminconsole.client.base.util.SmartGWTUtil;
import org.iplass.adminconsole.client.metadata.ui.top.PartsOperationHandler;
import org.iplass.adminconsole.shared.metadata.rpc.MetaDataServiceAsync;
import org.iplass.adminconsole.shared.metadata.rpc.MetaDataServiceFactory;
import org.iplass.mtp.view.generic.EntityView;
import org.iplass.mtp.view.top.parts.UserMaintenanceParts;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author lis3wg
 */
public class UserMaintenanceItem extends PartsItem {
	private PartsOperationHandler controler;

	private UserMaintenanceParts parts;

	private MetaDataServiceAsync service;

	/**
	 * コンストラクタ
	 */
	public UserMaintenanceItem(UserMaintenanceParts parts, PartsOperationHandler controler) {
		this.parts = parts;
		this.controler = controler;
		this.service = MetaDataServiceFactory.get();
		setTitle("User Maintenance");
		setBackgroundColor("#909090");

		setHeaderControls(HeaderControls.HEADER_LABEL, new HeaderControl(HeaderControl.SETTINGS, new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				UserMaintenanceItemSettingDialog dialog = new UserMaintenanceItemSettingDialog();
				dialog.show();
			}
		}), HeaderControls.CLOSE_BUTTON);
	}

	@Override
	public UserMaintenanceParts getParts() {
		return parts;
	}

	@Override
	protected boolean onPreDestroy() {
		MTPEvent e = new MTPEvent();
		e.setValue("key", dropAreaType + "_" + UserMaintenanceParts.class.getName() + "_");
		controler.remove(e);
		return true;
	}

	private class UserMaintenanceItemSettingDialog extends AbstractWindow {

		private static final String USER_DEFINITION_NAME = "mtp.auth.User";
		private SelectItem viewField;

		/**
		 * コンストラクタ
		 */
		public UserMaintenanceItemSettingDialog() {
			setTitle("User Maintenance");
			setHeight(130);
			setWidth(430);

			setShowMinimizeButton(false);
			setIsModal(true);
			setShowModalMask(true);
			centerInPage();

			final DynamicForm form = new DynamicForm();
			form.setAutoFocus(true);
			form.setCellPadding(5);
			form.setNumCols(3);
			form.setColWidths(100, 280, "*");

			viewField = new SelectItem("view", "User View");
			viewField.setWidth("100%");
			viewField.setDisabled(true);
			viewField.setValue(parts.getViewName());
			getViewList(USER_DEFINITION_NAME);

			form.setItems(viewField);

			VLayout mainLayout = new VLayout();
			mainLayout.setWidth100();
			mainLayout.setHeight100();
			mainLayout.setMargin(10);
			mainLayout.setMembersMargin(10);
			mainLayout.addMember(form);

			IButton save = new IButton("OK");
			save.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if (form.validate()){
						//入力情報をパーツに
						parts.setViewName(SmartGWTUtil.getStringValue(viewField));
						destroy();
					}
				}
			});

			IButton cancel = new IButton("Cancel");
			cancel.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					destroy();
				}
			});

			HLayout footer = new HLayout(5);
			footer.setMargin(5);
			footer.setHeight(20);
			footer.setWidth100();
			footer.setAlign(VerticalAlignment.CENTER);
			footer.setMembers(save, cancel);

			addItem(mainLayout);
			addItem(SmartGWTUtil.separator());
			addItem(footer);
		}

		private void getViewList(String defName) {
			final LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
			if (defName == null || defName.isEmpty()) {
				viewField.setValueMap(valueMap);
			} else {
				service.getDefinition(TenantInfoHolder.getId(), EntityView.class.getName(), defName,
						new AsyncCallback<EntityView>() {

					@Override
					public void onSuccess(EntityView result) {
						viewField.setDisabled(false);
						if (result == null || result.getDetailFormViewNames().length == 0) {
							valueMap.put("", "default");
						} else {
							for (String viewName : result.getDetailFormViewNames()) {
								if (viewName.isEmpty()) {
									valueMap.put("", "default");
								} else {
									valueMap.put(viewName, viewName);
								}
							}
						}

						viewField.setValueMap(valueMap);
					}

					@Override
					public void onFailure(Throwable caught) {
						SC.say(AdminClientMessageUtil.getString("ui_metadata_top_item_UserMaintenanceItem_failed"),
								AdminClientMessageUtil.getString("ui_metadata_top_item_UserMaintenanceItem_failedGetScreenInfo") + caught.getMessage());

						GWT.log(caught.toString(), caught);
					}
				});
			}
		}

	}
}

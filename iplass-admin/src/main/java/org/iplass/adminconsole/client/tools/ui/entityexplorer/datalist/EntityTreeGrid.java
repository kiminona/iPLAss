/*
 * Copyright (C) 2013 INFORMATION SERVICES INTERNATIONAL - DENTSU, LTD. All Rights Reserved.
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

package org.iplass.adminconsole.client.tools.ui.entityexplorer.datalist;

import java.util.ArrayList;
import java.util.List;

import org.iplass.adminconsole.client.base.ui.widget.GridActionImgButton;
import org.iplass.adminconsole.client.base.util.SmartGWTUtil;
import org.iplass.adminconsole.client.tools.data.entityexplorer.SimpleEntityInfoTreeDS;
import org.iplass.adminconsole.client.tools.data.entityexplorer.SimpleEntityInfoTreeDS.FIELD_NAME;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;
import com.smartgwt.client.widgets.tree.events.DataArrivedHandler;

public class EntityTreeGrid extends TreeGrid {

	private static final String ERROR_ICON = "[SKINIMG]/actions/exclamation.png";

	public EntityTreeGrid() {
		setLeaveScrollbarGap(false);
		setCanSort(false);
		setCanFreezeFields(false);
		setSelectionAppearance(SelectionAppearance.CHECKBOX);
		setShowSelectedStyle(false);
		setShowPartialSelection(true);
		setCascadeSelection(true);
		setCanGroupBy(false);
		setCanPickFields(false);

		// この２つを指定することでcreateRecordComponentが有効
		setShowRecordComponents(true);
		setShowRecordComponentsByCell(true);

		addDataArrivedHandler(new DataArrivedHandler() {

			@Override
			public void onDataArrived(DataArrivedEvent event) {
				//Root配下を展開する
				//expandRoot();
				//Entityの一覧なので全展開させる
				expandAll();
			}
		});
	}

	@Override
	protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
		final String fieldName = this.getFieldName(colNum);
//		if ("explorerButton".equals(fieldName)) {
//			if (!record.getAttributeAsBoolean("isError")){
//				GridActionImgButton recordCanvas = new GridActionImgButton();
//				recordCanvas.setActionButtonSrc(EXPLORER_ICON);
//				recordCanvas.setActionButtonPrompt(SmartGWTUtil.getHoverString("選択EntityのMetaData編集画面を表示します。"));
//				recordCanvas.addActionClickHandler(new ClickHandler() {
//
//					@Override
//					public void onClick(ClickEvent event) {
//						String name = record.getAttributeAsString("name");
//						MetaDataSettingTreeGrid.showMetaDataEditPane(
//								MetaDataConstants.META_PREFIX_PATH_ENTITY, name);
//						//showExplorer(name);
//					}
//				});
//				return recordCanvas;
//			}
//		} else if ("error".equals(fieldName)) {
		if ("error".equals(fieldName)) {
			if (record.getAttributeAsBoolean("isError")){
				record.setEnabled(false);
				GridActionImgButton recordCanvas = new GridActionImgButton();
				recordCanvas.setActionButtonSrc(ERROR_ICON);
				recordCanvas.setActionButtonPrompt(record.getAttributeAsString("errorMessage"));
				return recordCanvas;
			}
		}
		return null;
	}

	public void refreshGrid(boolean isGetDataCount) {

		setDataSource(SimpleEntityInfoTreeDS.getInstance(isGetDataCount));

		TreeGridField errorField = new TreeGridField("error", " ");
		errorField.setWidth(25);
		TreeGridField displayNameField = new TreeGridField(FIELD_NAME.DISPLAY_NAME.name(), "Name");
		TreeGridField pathField = new TreeGridField(FIELD_NAME.PATH.name(), "Path");
		pathField.setShowHover(true);
		pathField.setHoverCustomizer(new HoverCustomizer() {
			@Override
			public String hoverHTML(Object value, ListGridRecord record,
					int rowNum, int colNum) {
				return SmartGWTUtil.getHoverString(record.getAttribute(FIELD_NAME.PATH.name()));
			}
		});

		TreeGridField countField = new TreeGridField(FIELD_NAME.DATA_COUNT.name(), "Data Count");
		countField.setWidth(70);
		TreeGridField listenerCountField = new TreeGridField(FIELD_NAME.LISTNER_COUNT.name(), "Listeners");
		listenerCountField.setWidth(75);
		TreeGridField detailViewCountField = new TreeGridField(FIELD_NAME.DETAIL_VIEW_COUNT.name(), "DetailViews");
		detailViewCountField.setWidth(95);
		TreeGridField searchViewCountField = new TreeGridField(FIELD_NAME.SEARCH_VIEW_COUNT.name(), "SearchViews");
		searchViewCountField.setWidth(95);

		TreeGridField repositoryField = new TreeGridField(FIELD_NAME.REPOSITORY.name(), "Repository", 70);
		repositoryField.setAlign(Alignment.CENTER);
		repositoryField.setShowHover(true);
		repositoryField.setHoverCustomizer(new HoverCustomizer() {
			@Override
			public String hoverHTML(Object value, ListGridRecord record,
					int rowNum, int colNum) {
				return SmartGWTUtil.getHoverString(record.getAttribute(FIELD_NAME.REPOSITORY.name()));
			}
		});
		setFields(displayNameField, errorField, pathField, countField, listenerCountField, detailViewCountField, searchViewCountField, repositoryField);

		fetchData();
	}

	public void expandRoot() {
		getTree().closeAll();
		getTree().openFolders(
				getTree().getChildren(getTree().getRoot()));
	}

	public void expandAll() {
		getTree().openAll();
	}

	public boolean isSelected() {
		//trueを指定することでPathは全て選択されていないと含まれない
		ListGridRecord[] records = getSelectedRecords(true);
		if (records == null || records.length == 0) {
			return false;
		}
		return true;
	}

	public List<String> getSelectedPathList() {
		//中間レコードは除外して取得
		ListGridRecord[] records = getSelectedRecords(true);
		List<String> selectPaths = new ArrayList<String>();
		for (ListGridRecord record : records) {
			String path = record.getAttribute(FIELD_NAME.PATH.name());
			//Rootは除外
			if (path == null || path.isEmpty()) {
				continue;
			}

			TreeNode node = (TreeNode)record;
			if (!getTree().isFolder(node)) {
				//Folderは対象にならない想定だが、念のためチェック
				selectPaths.add(path);
			}
		}

		return selectPaths;
	}

	public String[] getSelectedPathArray() {
		return getSelectedPathList().toArray(new String[] {});
	}
}

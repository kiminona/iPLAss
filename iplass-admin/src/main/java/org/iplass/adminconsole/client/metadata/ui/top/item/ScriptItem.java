/*
 * Copyright (C) 2011 INFORMATION SERVICES INTERNATIONAL - DENTSU, LTD. All Rights Reserved.
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

import org.iplass.adminconsole.client.base.ui.widget.ScriptEditorDialogCondition;
import org.iplass.adminconsole.client.base.ui.widget.ScriptEditorDialogHandler;
import org.iplass.adminconsole.client.base.ui.widget.ScriptEditorDialogMode;
import org.iplass.adminconsole.client.metadata.ui.MetaDataUtil;
import org.iplass.mtp.view.top.parts.ScriptParts;

import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 *
 * @author lis3wg
 */
public class ScriptItem extends PartsItem {

	private ScriptParts parts;

	/**
	 * コンストラクタ
	 */
	public ScriptItem(ScriptParts parts) {
		this.parts = parts;
		setTitle("Script");
		setBackgroundColor("#F9F9F9");

		setHeaderControls(HeaderControls.HEADER_LABEL, new HeaderControl(HeaderControl.SETTINGS, new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MetaDataUtil.showScriptEditDialog(ScriptEditorDialogMode.JSP,
						ScriptItem.this.parts.getScript(),
						ScriptEditorDialogCondition.TOPVIEW_SCRIPT_ITEM,
						"ui_metadata_top_item_ScriptItem_scriptHint",
						null,
						new ScriptEditorDialogHandler() {

							@Override
							public void onSave(String text) {
								ScriptItem.this.parts.setScript(text);
							}
							@Override
							public void onCancel() {
							}
						});
			}
		}), HeaderControls.CLOSE_BUTTON);
	}

	@Override
	public ScriptParts getParts() {
		return parts;
	}

}

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

package org.iplass.adminconsole.client.metadata.ui.top.item;

import org.iplass.adminconsole.client.base.event.MTPEvent;
import org.iplass.adminconsole.client.base.ui.widget.AbstractWindow;
import org.iplass.adminconsole.client.base.util.SmartGWTUtil;
import org.iplass.adminconsole.client.metadata.ui.top.PartsOperationHandler;
import org.iplass.mtp.view.top.parts.CsvDownloadSettingsParts;

import com.google.gwt.core.shared.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 *
 * @author lis3wg
 */
public class CsvDownloadSettingsItem extends PartsItem {

	private PartsOperationHandler controler;
	private CsvDownloadSettingsParts parts;

	/**
	 * コンストラクタ
	 */
	public CsvDownloadSettingsItem(CsvDownloadSettingsParts parts, PartsOperationHandler controler) {
		this.parts = parts;
		this.controler = controler;
		setTitle("CsvDownload Settings");
		setBackgroundColor("#B0B0B0");

		setHeaderControls(HeaderControls.HEADER_LABEL, new HeaderControl(HeaderControl.SETTINGS, new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				CsvDownloadSettingsItemSettingDialog dialog = new CsvDownloadSettingsItemSettingDialog();
				dialog.show();
			}
		}), HeaderControls.CLOSE_BUTTON);
	}

	@Override
	public CsvDownloadSettingsParts getParts() {
		return parts;
	}

	@Override
	protected boolean onPreDestroy() {
		MTPEvent e = new MTPEvent();
		e.setValue("key", dropAreaType + "_" + CsvDownloadSettingsParts.class.getName() + "_");
		controler.remove(e);
		return true;
	}

	private class CsvDownloadSettingsItemSettingDialog extends AbstractWindow {

		private CsvDownloadSettingsPartsFormController formController = GWT.create(CsvDownloadSettingsPartsFormController.class);

		/**
		 * コンストラクタ
		 */
		public CsvDownloadSettingsItemSettingDialog() {
			setTitle("CsvDownload Settings");
			setHeight(170);
			setWidth(430);
			setMargin(10);
			setMembersMargin(10);

			setShowMinimizeButton(false);
			setIsModal(true);
			setShowModalMask(true);
			centerInPage();

			final DynamicForm form = new DynamicForm();
			form.setAlign(Alignment.CENTER);
			form.setAutoFocus(true);

			formController.createForm(parts, form);

			HLayout footer = new HLayout(5);
			footer.setMargin(10);
			footer.setWidth100();
			footer.setAlign(VerticalAlignment.CENTER);

			IButton save = new IButton("OK");
			save.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if (form.validate()){
						formController.applyTo(parts);
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

			footer.setMembers(save, cancel);

			addItem(form);
			addItem(footer);
		}
	}

	public interface CsvDownloadSettingsPartsFormController {

		void createForm(CsvDownloadSettingsParts parts, DynamicForm form);

		void applyTo(CsvDownloadSettingsParts parts);
	}

	public static class CsvDownloadSettingsPartsFormControllerImpl implements CsvDownloadSettingsPartsFormController {

		private CheckboxItem specfyCharacterCodeEntityView;

		@Override
		public void createForm(CsvDownloadSettingsParts parts, DynamicForm form) {

			specfyCharacterCodeEntityView = new CheckboxItem();
			specfyCharacterCodeEntityView.setTitle("SpecfyCharacterCodeEntityView");
			specfyCharacterCodeEntityView.setName("specfyCharacterCodeEntityView");
			specfyCharacterCodeEntityView.setValue(parts.isSpecfyCharacterCodeEntityView());

			form.setItems(specfyCharacterCodeEntityView);
		}

		@Override
		public void applyTo(CsvDownloadSettingsParts parts) {
			parts.setSpecfyCharacterCodeEntityView(SmartGWTUtil.getBooleanValue(specfyCharacterCodeEntityView));
		}

	}
}

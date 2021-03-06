/*
 * Copyright (C) 2017 INFORMATION SERVICES INTERNATIONAL - DENTSU, LTD. All Rights Reserved.
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

package org.iplass.adminconsole.client.metadata.ui.entity.property.type;

import java.util.LinkedHashMap;

import org.iplass.adminconsole.client.base.i18n.AdminClientMessageUtil;
import org.iplass.adminconsole.client.base.util.SmartGWTUtil;
import org.iplass.adminconsole.client.metadata.data.MetaDataNameDS;
import org.iplass.adminconsole.client.metadata.data.MetaDataNameDS.MetaDataNameDSOption;
import org.iplass.adminconsole.client.metadata.ui.entity.property.PropertyAttribute;
import org.iplass.adminconsole.client.metadata.ui.entity.property.PropertyAttributePane;
import org.iplass.adminconsole.client.metadata.ui.entity.property.PropertyListGridRecord;
import org.iplass.mtp.entity.definition.PropertyDefinitionType;
import org.iplass.mtp.entity.definition.properties.selectvalue.SelectValueDefinition;

import com.google.gwt.core.shared.GWT;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class ExpressionAttributePane extends VLayout implements PropertyAttributePane {

	private DynamicForm form = new DynamicForm();

	/** 式 */
	private TextAreaItem txtExpression;

	private DynamicForm formResultType = new DynamicForm();

	/** 結果タイプ */
	private SelectItem selResultType;
	/** 結果タイプがSelect時のSelectValue */
	private SelectItem selGlobalSelectValue;
//	private MetaDataViewButtonItem btnGlobalSelectValueMeta;

	private PropertyTypeAttributeController typeController = GWT.create(PropertyTypeAttributeController.class);

	public ExpressionAttributePane() {

		setWidth100();
//		setHeight100();
		setAutoHeight();

		selResultType = new SelectItem();
		selResultType.setTitle("Result Type");
		selResultType.setWidth(200);
		selResultType.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				changeExpressionResultType();
			}
		});

		selGlobalSelectValue = new SelectItem();
		selGlobalSelectValue.setTitle("Global Value");
		selGlobalSelectValue.setWidth(200);

		MetaDataNameDS.setDataSource(selGlobalSelectValue, SelectValueDefinition.class, new MetaDataNameDSOption(true, false, rs("ui_metadata_entity_PropertyListGrid_expressionGlobalSelectValueComment")));
		SmartGWTUtil.addHoverToFormItem(selGlobalSelectValue, rs("ui_metadata_entity_PropertyListGrid_expressionGlobalSelectValueComment"));
		//#19232
//		btnGlobalSelectValueMeta = new MetaDataViewButtonItem(SelectValueDefinition.class.getName());
//		btnGlobalSelectValueMeta.setPrompt(SmartGWTUtil.getHoverString("view the selected global value"));
//		btnGlobalSelectValueMeta.setMetaDataShowClickHandler(
//				new MetaDataViewButtonItem.MetaDataShowClickHandler() {
//			@Override
//			public String targetDefinitionName() {
//				return SmartGWTUtil.getStringValue(selGlobalSelectValue);
//			}
//		});

		txtExpression = new TextAreaItem();
		txtExpression.setTitle(rs("ui_metadata_entity_PropertyListGrid_expression"));
		txtExpression.setWidth("100%");
		txtExpression.setHeight(100);
		txtExpression.setColSpan(6);
		SmartGWTUtil.setRequired(txtExpression);
		SmartGWTUtil.addHoverToFormItem(txtExpression, rs("ui_metadata_entity_PropertyListGrid_expressionItem"));

		formResultType.setMargin(5);
		formResultType.setNumCols(6);
		formResultType.setColWidths(100, 200, 100, 200, 50, "*");
		formResultType.setWidth100();
		formResultType.setHeight(30);
//		formResultType.setItems(selResultType, selGlobalSelectValue, btnGlobalSelectValueMeta);
		formResultType.setItems(selResultType, selGlobalSelectValue);

		form.setMargin(5);
		form.setNumCols(6);
		form.setWidth100();
		form.setHeight(80);
		form.setItems(txtExpression);

		addMember(formResultType);
		addMember(form);

		initialize();
	}

	@Override
	public void applyFrom(String defName, PropertyListGridRecord record, PropertyAttribute typeAttribute) {

		ExpressionAttribute expressionAttribute = (ExpressionAttribute)typeAttribute;

		txtExpression.setValue(expressionAttribute.getExpression());
		if (expressionAttribute.getResultType() != null) {
			selResultType.setValue(expressionAttribute.getResultType());
		} else {
			selResultType.setValue("");
		}
		if (expressionAttribute.getGlobalSelectName() != null) {
			selGlobalSelectValue.setValue(expressionAttribute.getGlobalSelectName());
		} else {
			selGlobalSelectValue.setValue("");
		}

		if (PropertyDefinitionType.SELECT == expressionAttribute.getResultType()) {
			selGlobalSelectValue.setVisible(true);
//			btnGlobalSelectValueMeta.setVisible(true);
		} else {
			selGlobalSelectValue.setVisible(false);
//			btnGlobalSelectValueMeta.setVisible(false);
		}

	}

	@Override
	public void applyTo(PropertyListGridRecord record) {

		ExpressionAttribute expressionAttribute = (ExpressionAttribute)record.getTypeAttribute();

		if (txtExpression.getValue() != null) {
			expressionAttribute.setExpression(SmartGWTUtil.getStringValue(txtExpression));
		} else {
			expressionAttribute.setExpression(null);
		}
		PropertyDefinitionType expressionResultType = null;
		if (SmartGWTUtil.isNotEmpty(SmartGWTUtil.getStringValue(selResultType))) {
			expressionResultType = PropertyDefinitionType.valueOf(SmartGWTUtil.getStringValue(selResultType));
			expressionAttribute.setResultType(expressionResultType);
		} else {
			expressionAttribute.setResultType(null);
		}
		if (PropertyDefinitionType.SELECT == expressionResultType) {
			expressionAttribute.setGlobalSelectName(SmartGWTUtil.getStringValue(selGlobalSelectValue));
		} else {
			expressionAttribute.setGlobalSelectName(null);
		}
	}

	@Override
	public boolean validate() {

		boolean isValidate = true;
		//共通Formチェック
		if (!formResultType.validate()) {
			isValidate = false;
		}
		if (!form.validate()) {
			isValidate = false;
		}

		return isValidate;
	}

	@Override
	public int panelHeight() {
		return 160;
	}

	private void initialize() {

		LinkedHashMap<String, String> resultTypeMap = new LinkedHashMap<String, String>();
		resultTypeMap.put("", "");
		for (PropertyDefinitionType type : typeController.getExpressionResultTypes()) {
			resultTypeMap.put(type.name(), typeController.getTypeDisplayName(type));
		}
		selResultType.setValueMap(resultTypeMap);
	}

	private void changeExpressionResultType() {

		if (PropertyDefinitionType.SELECT.name().equals(SmartGWTUtil.getStringValue(selResultType))) {
			selGlobalSelectValue.show();
//			btnGlobalSelectValueMeta.show();
		} else {
			selGlobalSelectValue.hide();
//			btnGlobalSelectValueMeta.hide();
			selGlobalSelectValue.setValue("");
		}
	}

	private String rs(String key) {
		return AdminClientMessageUtil.getString(key);
	}
}

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

package org.iplass.mtp.view.generic.element.section;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.iplass.adminconsole.annotation.MultiLang;
import org.iplass.adminconsole.view.annotation.InputType;
import org.iplass.adminconsole.view.annotation.MetaFieldInfo;
import org.iplass.adminconsole.view.annotation.generic.EntityViewField;
import org.iplass.adminconsole.view.annotation.generic.FieldReferenceType;
import org.iplass.mtp.definition.LocalizedStringDefinition;
import org.iplass.mtp.view.generic.Jsp;
import org.iplass.mtp.view.generic.Jsps;
import org.iplass.mtp.view.generic.ViewConst;

/**
 * JSPによるカスタマイズ可能なセクション
 * @author lis3wg
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Jsps({
	@Jsp(path="/jsp/gem/generic/element/section/TemplateSection.jsp", key=ViewConst.DESIGN_TYPE_GEM)
})
public class TemplateSection extends Section {

	/** シリアルバージョンUID */
	private static final long serialVersionUID = 2395869879339480230L;

	/**
	 * デフォルトコンストラクタ
	 */
	public TemplateSection() {
	}

	/** テンプレート名 */
	@MetaFieldInfo(
			displayName="テンプレート名",
			displayNameKey="generic_element_section_TemplateSection_templateNameDisplaNameKey",
			inputType=InputType.TEMPLATE,
			required=true,
			description="表示時に読み込むテンプレートの名前を設定します",
			descriptionKey="generic_element_section_TemplateSection_templateNameDescriptionKey"
	)
	@EntityViewField(
			referenceTypes={FieldReferenceType.ALL}
	)
	private String templateName;

	/** タイトル */
	@MetaFieldInfo(
			displayName="タイトル",
			displayNameKey="generic_element_section_TemplateSection_titleDisplaNameKey",
			description="セクションのタイトルを設定します。",
			descriptionKey="generic_element_section_TemplateSection_titleDescriptionKey",
			useMultiLang=true
	)
	@EntityViewField(
			referenceTypes={FieldReferenceType.ALL}
	)
	@MultiLang()
	private String title;

	/** 多言語設定情報 */
	@MetaFieldInfo(
			displayName="多言語設定",
			displayNameKey="generic_element_section_TemplateSection_localizedTitleListDisplaNameKey",
			inputType=InputType.LANGUAGE
	)
	@EntityViewField(
			referenceTypes={FieldReferenceType.ALL}
	)
	private List<LocalizedStringDefinition> localizedTitleList;

	/** id */
	@MetaFieldInfo(
			displayName="id",
			displayNameKey="generic_element_section_TemplateSection_idDisplaNameKey",
			description="画面上で一意となるIDを設定してください。",
			descriptionKey="generic_element_section_TemplateSection_idDescriptionKey"
	)
	@EntityViewField(
			referenceTypes={FieldReferenceType.ALL}
	)
	private String id;

	/** リンクを表示するか */
	@MetaFieldInfo(
			displayName="リンクを表示するか",
			displayNameKey="generic_element_section_TemplateSection_showLinkDisplaNameKey",
			inputType=InputType.CHECKBOX,
			description="詳細画面でのページ内リンクを表示するかを指定します。",
			descriptionKey="generic_element_section_TemplateSection_showLinkDescriptionKey"
	)
	@EntityViewField(
			referenceTypes={FieldReferenceType.DETAIL}
	)
	private boolean showLink;

	/** 詳細編集非表示設定 */
	@MetaFieldInfo(
			displayName="詳細編集非表示設定",
			displayNameKey="generic_element_section_TemplateSection_hideDetailDisplaNameKey",
			inputType=InputType.CHECKBOX,
			description="詳細編集で非表示にするかを設定します。",
			descriptionKey="generic_element_section_TemplateSection_hideDetailDescriptionKey"
	)
	@EntityViewField(
			referenceTypes={FieldReferenceType.DETAIL}
	)
	private boolean hideDetail;

	/** 詳細表示非表示設定 */
	@MetaFieldInfo(
			displayName="詳細表示非表示設定",
			displayNameKey="generic_element_section_TemplateSection_hideViewDisplaNameKey",
			inputType=InputType.CHECKBOX,
			description="詳細表示で非表示にするかを設定します。",
			descriptionKey="generic_element_section_TemplateSection_hideViewDescriptionKey"
	)
	@EntityViewField(
			referenceTypes={FieldReferenceType.DETAIL}
	)
	private boolean hideView;

	/**
	 * テンプレート名を取得します。
	 * @return テンプレート名
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * テンプレート名を設定します。
	 * @param templateName テンプレート名
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * タイトルを取得します。
	 * @return タイトル
	 */
	public String getTitle() {
	    return title;
	}

	/**
	 * タイトルを設定します。
	 * @param title タイトル
	 */
	public void setTitle(String title) {
	    this.title = title;
	}

	/**
	 * idを取得します。
	 * @return id
	 */
	public String getId() {
	    return id;
	}

	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * リンクを表示するかを取得します。
	 * @return リンクを表示するか
	 */
	public boolean isShowLink() {
	    return showLink;
	}

	/**
	 * リンクを表示するかを設定します。
	 * @param showLink リンクを表示するか
	 */
	public void setShowLink(boolean showLink) {
	    this.showLink = showLink;
	}

	/**
	 * 詳細編集非表示設定を取得します。
	 * @return 詳細編集非表示設定
	 */
	public boolean isHideDetail() {
	    return hideDetail;
	}

	/**
	 * 詳細編集非表示設定を設定します。
	 * @param hideDetail 詳細編集非表示設定
	 */
	public void setHideDetail(boolean hideDetail) {
	    this.hideDetail = hideDetail;
	}

	/**
	 * 詳細表示非表示設定を取得します。
	 * @return 詳細表示非表示設定
	 */
	public boolean isHideView() {
	    return hideView;
	}

	/**
	 * 詳細表示非表示設定を設定します。
	 * @param hideView 詳細表示非表示設定
	 */
	public void setHideView(boolean hideView) {
	    this.hideView = hideView;
	}

	/**
	 * 多言語設定情報を取得します。
	 * @return リスト
	 */
	public List<LocalizedStringDefinition> getLocalizedTitleList() {
		return localizedTitleList;
	}

	/**
	 * 多言語設定情報を設定します。
	 * @param リスト
	 */
	public void setLocalizedTitleList(List<LocalizedStringDefinition> localizedTitleList) {
		this.localizedTitleList = localizedTitleList;
	}

	/**
	 * 多言語設定情報を追加します。
	 * @param 多言語設定情報
	 */
	public void addLocalizedTitle(LocalizedStringDefinition localizedTitle) {
		if (localizedTitleList == null) {
			localizedTitleList = new ArrayList<LocalizedStringDefinition>();
		}

		localizedTitleList.add(localizedTitle);
	}

}

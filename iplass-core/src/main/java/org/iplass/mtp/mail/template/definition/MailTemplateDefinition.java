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

package org.iplass.mtp.mail.template.definition;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.iplass.mtp.definition.Definition;

/**
 * メールテンプレート定義
 */
@XmlRootElement
public class MailTemplateDefinition implements Definition {

	private static final long serialVersionUID = -3540273697496545764L;

	private String name;
	private String displayName;
	private String description;

	private String charset;

	private String subject;

	private PlainTextBodyPart plainMessage;

	private HtmlBodyPart htmlMessage;

	private List<LocalizedMailTemplateDefinition> localizedMailTemplateList;

	private String langOrUserBindingName;

	private String from;
	private String replyTo;
	private String returnPath;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getReturnPath() {
		return returnPath;
	}

	public void setReturnPath(String returnPath) {
		this.returnPath = returnPath;
	}

	public String getLangOrUserBindingName() {
		return langOrUserBindingName;
	}

	public void setLangOrUserBindingName(String bindKey) {
		this.langOrUserBindingName = bindKey;
	}

	public List<LocalizedMailTemplateDefinition> getLocalizedMailTemplateList() {
		return localizedMailTemplateList;
	}

	public void setLocalizedMailTemplateList(
			List<LocalizedMailTemplateDefinition> localizedMailTemplateList) {
		this.localizedMailTemplateList = localizedMailTemplateList;
	}

	public void addLocalizedMailTemplate(LocalizedMailTemplateDefinition localizedMailTemplate) {
		if (localizedMailTemplateList == null) {
			localizedMailTemplateList = new ArrayList<LocalizedMailTemplateDefinition>();
		}

		localizedMailTemplateList.add(localizedMailTemplate);
	}

	/**
	 * 名前を取得します。
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前を設定します。
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 表示名を取得します。
	 * @return 表示名
	 */
	public String getDisplayName() {
	    return displayName;
	}

	/**
	 * 表示名を設定します。
	 * @param displayName 表示名
	 */
	public void setDisplayName(String displayName) {
	    this.displayName = displayName;
	}

	/**
	 * 説明を取得します。
	 * @return 説明
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 説明を設定します。
	 * @param description 説明
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 文字コードを取得します。
	 * @return 文字コード
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * 文字コードを設定します。
	 * @param charset 文字コード
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * 件名を取得します。
	 * @return 件名
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 件名を設定します。
	 * @param subject 件名
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * テキストメッセージを取得します。
	 * @return テキストメッセージ
	 */
	public PlainTextBodyPart getPlainMessage() {
		return plainMessage;
	}

	/**
	 * テキストメッセージを設定します。
	 * @param plainMessage テキストメッセージ
	 */
	public void setPlainMessage(PlainTextBodyPart plainMessage) {
		this.plainMessage = plainMessage;
	}

	/**
	 * HTMLメッセージを取得します。
	 * @return HTMLメッセージ
	 */
	public HtmlBodyPart getHtmlMessage() {
		return htmlMessage;
	}

	/**
	 * HTMLメッセージを設定します。
	 * @param htmlMessage HTMLメッセージ
	 */
	public void setHtmlMessage(HtmlBodyPart htmlMessage) {
		this.htmlMessage = htmlMessage;
	}
}

/*
 * Copyright (C) 2018 INFORMATION SERVICES INTERNATIONAL - DENTSU, LTD. All Rights Reserved.
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

package org.iplass.mtp.view.generic;

import java.io.Serializable;

/**
 * Viewの管理設定
 */
public class ViewControlSetting implements Serializable {

	private static final long serialVersionUID = 3898521683896716264L;

	/** View名 */
	private String name;

	/** 検索画面を自動生成 */
	private boolean autoGenerateSearchView;

	/** 詳細画面を自動生成 */
	private boolean autoGenerateDetailView;

	/** 許可ロール */
	private String permitRoles;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return autoGenerateSearchView
	 */
	public boolean isAutoGenerateSearchView() {
		return autoGenerateSearchView;
	}

	/**
	 * @param autoGenerateSearchView セットする autoGenerateSearchView
	 */
	public void setAutoGenerateSearchView(boolean autoGenerateSearchView) {
		this.autoGenerateSearchView = autoGenerateSearchView;
	}

	/**
	 * @return autoGenerateDetailView
	 */
	public boolean isAutoGenerateDetailView() {
		return autoGenerateDetailView;
	}

	/**
	 * @param autoGenerateDetailView セットする autoGenerateDetailView
	 */
	public void setAutoGenerateDetailView(boolean autoGenerateDetailView) {
		this.autoGenerateDetailView = autoGenerateDetailView;
	}

	/**
	 * 許可ロールを取得します。
	 * @return 許可ロール
	 */
	public String getPermitRoles() {
		return permitRoles;
	}

	/**
	 * 許可ロールを設定します。
	 * @param permitRoles 許可ロール
	 */
	public void setPermitRoles(String permitRoles) {
		this.permitRoles = permitRoles;
	}
}
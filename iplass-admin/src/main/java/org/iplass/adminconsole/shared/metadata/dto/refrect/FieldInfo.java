/*
 * Copyright (C) 2015 INFORMATION SERVICES INTERNATIONAL - DENTSU, LTD. All Rights Reserved.
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

package org.iplass.adminconsole.shared.metadata.dto.refrect;

import java.io.Serializable;

import org.iplass.adminconsole.shared.metadata.dto.Name;
import org.iplass.adminconsole.view.annotation.InputType;
import org.iplass.adminconsole.view.annotation.generic.FieldReferenceType;

/**
 * メタデータのフィールド情報
 * @author lis3wg
 */
public class FieldInfo implements Serializable {
	/** シリアルバージョンID */
	private static final long serialVersionUID = -7053219457507848232L;

	/** フィールド名 */
	private String name;

	/** 表示名 */
	private String displayName;

	/** 表示名のキー */
	private String displayNameKey;

	/** 入力タイプ */
	private InputType inputType;

	/** 必須入力か */
	private boolean required;

	/** 範囲チェックを行うか */
	private boolean rangeCheck;

	/** 最大範囲 */
	private int maxRange;

	/** 最小範囲 */
	private int minRange;

	/** 多重度 */
	private boolean multiple;

	/** 参照型クラス */
	private String referenceClassName;

	/** 参照クラス(固定) */
	private Name[] fixedReferenceClass;

	/** Enum値のクラス名 */
	private String enumClassName;

	/** Enum値の配列 */
	private Serializable[] enumValues;

	/** スクリプトのモード */
	private String mode;

	/** フィールドの説明 */
	private String description;

	/** フィールドの説明のキー */
	private String descriptionKey;

	/**
	 * 多言語設定を利用するか
	 */
	private boolean useMultiLang;

	/** inputTypeがPropertyの場合、そのプロパティの型を別の入力項目のProperty選択に利用するか */
	private boolean useReferenceType;

	/** inputTypeがPropertyの場合、このプロパティの選択肢を取得するためのEntity定義名 */
	private String entityDefinitionName;

	/** 非推奨または未使用の項目か */
	private boolean deprecated;

	/** EntityViewのプロパティとして参照するタイプ */
	private FieldReferenceType[] entityViewReferenceType;


	/**
	 * コンストラクタ
	 */
	public FieldInfo() {
	}

	/**
	 * フィールド名を取得します。
	 * @return フィールド名
	 */
	public String getName() {
		return name;
	}

	/**
	 * フィールド名を設定します。
	 * @param name フィールド名
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
	 * 表示名のキーを取得します。
	 * @return 表示名のキー
	 */
	public String getDisplayNameKey() {
		return displayNameKey;
	}

	/**
	 * 表示名のキーを設定します。
	 * @param displayNameKey 表示名のキー
	 */
	public void setDisplayNameKey(String displayNameKey) {
		this.displayNameKey = displayNameKey;
	}

	/**
	 * 入力タイプを取得します。
	 * @return 入力タイプ
	 */
	public InputType getInputType() {
		return inputType;
	}

	/**
	 * 入力タイプを設定します。
	 * @param inputType 入力タイプ
	 */
	public void setInputType(InputType inputType) {
		this.inputType = inputType;
	}

	/**
	 * 必須入力かを取得します。
	 * @return 必須入力か
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * 必須入力かを設定します。
	 * @param required 必須入力か
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * 範囲チェックを行うかを取得します。
	 * @return 範囲チェックを行うか
	 */
	public boolean isRangeCheck() {
		return rangeCheck;
	}

	/**
	 * 範囲チェックを行うかを設定します。
	 * @param rangeCheck 範囲チェックを行うか
	 */
	public void setRangeCheck(boolean rangeCheck) {
		this.rangeCheck = rangeCheck;
	}

	/**
	 * 最大範囲を取得します。
	 * @return 最大範囲
	 */
	public int getMaxRange() {
		return maxRange;
	}

	/**
	 * 最大範囲を設定します。
	 * @param maxRange 最大範囲
	 */
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	/**
	 * 最小範囲を取得します。
	 * @return 最小範囲
	 */
	public int getMinRange() {
		return minRange;
	}

	/**
	 * 最小範囲を設定します。
	 * @param minRange 最小範囲
	 */
	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}

	/**
	 * 多重度を取得します。
	 * @return 多重度
	 */
	public boolean isMultiple() {
		return multiple;
	}

	/**
	 * 多重度を設定します。
	 * @param multiple 多重度
	 */
	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	/**
	 * 参照型クラスを取得します。
	 * @return 参照型クラス
	 */
	public String getReferenceClassName() {
		return referenceClassName;
	}

	/**
	 * 参照型クラスを設定します。
	 * @param referenceClassName 参照型クラス
	 */
	public void setReferenceClassName(String referenceClassName) {
		this.referenceClassName = referenceClassName;
	}

	/**
	 * 参照型クラス(固定)を取得します。
	 * @return 参照型クラス(固定)
	 */
	public Name[] getFixedReferenceClass() {
		return fixedReferenceClass;
	}

	/**
	 * 参照型クラス(固定)を設定します。
	 * @param referenceClassName 参照型クラス(固定)
	 */
	public void setFixedReferenceClass(Name[] fixedReferenceClass) {
		this.fixedReferenceClass = fixedReferenceClass;
	}

	/**
	 * Enum値のクラス名を取得します。
	 * @return Enum値のクラス名
	 */
	public String getEnumClassName() {
	    return enumClassName;
	}

	/**
	 * Enum値のクラス名を設定します。
	 * @param enumClassName Enum値のクラス名
	 */
	public void setEnumClassName(String enumClassName) {
	    this.enumClassName = enumClassName;
	}

	/**
	 * Enum値の配列を取得します。
	 * @return Enum値の配列
	 */
	public Serializable[] getEnumValues() {
		return enumValues;
	}

	/**
	 * Enum値の配列を設定します。
	 * @param enumValues Enum値の配列
	 */
	public void setEnumValues(Serializable[] enumValues) {
		this.enumValues = enumValues;
	}

	/**
	 * スクリプトのモードを取得します。
	 * @return スクリプトのモード
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * スクリプトのモードを設定します。
	 * @param mode スクリプトのモード
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * フィールドの説明を取得します。
	 * @return フィールドの説明
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * フィールドの説明を設定します。
	 * @param description フィールドの説明
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * フィールドの説明のキーを取得します。
	 * @return フィールドの説明のキー
	 */
	public String getDescriptionKey() {
		return descriptionKey;
	}

	/**
	 * フィールドの説明のキーを設定します。
	 * @param descriptionKey フィールドの説明のキー
	 */
	public void setDescriptionKey(String descriptionKey) {
		this.descriptionKey = descriptionKey;
	}

	/**
	 * 多言語設定を利用するかを取得します。
	 * @return 多言語設定を利用するか
	 */
	public boolean isUseMultiLang() {
		return useMultiLang;
	}

	/**
	 * 多言語設定を利用するかを設定します。
	 * @param useMultiLang 多言語設定を利用するか
	 */
	public void setUseMultiLang(boolean useMultiLang) {
		this.useMultiLang = useMultiLang;
	}

	/**
	 * @return useReferenceType
	 */
	public boolean isUseReferenceType() {
		return useReferenceType;
	}

	/**
	 * @param useReferenceType セットする useReferenceType
	 */
	public void setUseReferenceType(boolean useReferenceType) {
		this.useReferenceType = useReferenceType;
	}

	/**
	 * @return entityDefinitionName
	 */
	public String getEntityDefinitionName() {
		return entityDefinitionName;
	}

	/**
	 * @param entityDefinitionName セットする entityDefinitionName
	 */
	public void setEntityDefinitionName(String entityDefinitionName) {
		this.entityDefinitionName = entityDefinitionName;
	}

	/**
	 * 非推奨または未使用の項目かを取得します。
	 * @return 非推奨または未使用の項目か
	 */
	public boolean isDeprecated() {
	    return deprecated;
	}

	/**
	 * 非推奨または未使用の項目かを設定します。
	 * @param deprecated 非推奨または未使用の項目か
	 */
	public void setDeprecated(boolean deprecated) {
	    this.deprecated = deprecated;
	}


	/**
	 * EntityViewのプロパティとして参照するタイプを取得します。
	 * @return EntityViewのプロパティとして参照するタイプ
	 */
	public FieldReferenceType[] getEntityViewReferenceType() {
		return entityViewReferenceType;
	}

	/**
	 * EntityViewのプロパティとして参照するタイプを設定します。
	 * @param entityViewReferenceType EntityViewのプロパティとして参照するタイプ
	 */
	public void setEntityViewReferenceType(FieldReferenceType[] entityViewReferenceType) {
		this.entityViewReferenceType = entityViewReferenceType;
	}

}

/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.parts.model.impl;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Locale;

/**
 * The extended model implementation for the PurchaseOrder service. Represents a row in the &quot;Inventory_PurchaseOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.parts.model.PurchaseOrder} interface.
 * </p>
 *
 * @author Joe Bloggs
 */
public class PurchaseOrderImpl extends PurchaseOrderBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a purchase order model instance should use the {@link com.liferay.training.parts.model.PurchaseOrder} interface instead.
	 */
	public PurchaseOrderImpl() {
	}
	
	
	public String getPartName() {
		return partName;
	}

	public String getPartName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getPartName(languageId);
	}

	public String getPartName(String languageId) {
		String value = LocalizationUtil.getLocalization(getPartName(), languageId);

		if (isEscapedModel()) {
			return HtmlUtil.escape(value);
		}
		else {
			return value;
		}
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	private String partName;
	private String partNumber;
	private Long manufacturerId;

	
}
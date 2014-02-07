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

package com.liferay.training.parts.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the PurchaseOrder service. Represents a row in the &quot;Inventory_PurchaseOrder&quot; database table, with each column mapped to a property of this class.
 *
 * @author Joe Bloggs
 * @see PurchaseOrderModel
 * @see com.liferay.training.parts.model.impl.PurchaseOrderImpl
 * @see com.liferay.training.parts.model.impl.PurchaseOrderModelImpl
 * @generated
 */
public interface PurchaseOrder extends PurchaseOrderModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.training.parts.model.impl.PurchaseOrderImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getPartName();

	public java.lang.String getPartName(java.util.Locale locale);

	public java.lang.String getPartName(java.lang.String languageId);

	public void setPartName(java.lang.String partName);

	public java.lang.String getPartNumber();

	public void setPartNumber(java.lang.String partNumber);

	public java.lang.Long getManufacturerId();

	public void setManufacturerId(java.lang.Long manufacturerId);
}
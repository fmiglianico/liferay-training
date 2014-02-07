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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PurchaseOrder service. Represents a row in the &quot;Inventory_PurchaseOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.training.parts.model.impl.PurchaseOrderModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.training.parts.model.impl.PurchaseOrderImpl}.
 * </p>
 *
 * @author Joe Bloggs
 * @see PurchaseOrder
 * @see com.liferay.training.parts.model.impl.PurchaseOrderImpl
 * @see com.liferay.training.parts.model.impl.PurchaseOrderModelImpl
 * @generated
 */
public interface PurchaseOrderModel extends BaseModel<PurchaseOrder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a purchase order model instance should use the {@link PurchaseOrder} interface instead.
	 */

	/**
	 * Returns the primary key of this purchase order.
	 *
	 * @return the primary key of this purchase order
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this purchase order.
	 *
	 * @param primaryKey the primary key of this purchase order
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the order ID of this purchase order.
	 *
	 * @return the order ID of this purchase order
	 */
	public long getOrderId();

	/**
	 * Sets the order ID of this purchase order.
	 *
	 * @param orderId the order ID of this purchase order
	 */
	public void setOrderId(long orderId);

	/**
	 * Returns the company ID of this purchase order.
	 *
	 * @return the company ID of this purchase order
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this purchase order.
	 *
	 * @param companyId the company ID of this purchase order
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this purchase order.
	 *
	 * @return the group ID of this purchase order
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this purchase order.
	 *
	 * @param groupId the group ID of this purchase order
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the part ID of this purchase order.
	 *
	 * @return the part ID of this purchase order
	 */
	public long getPartId();

	/**
	 * Sets the part ID of this purchase order.
	 *
	 * @param partId the part ID of this purchase order
	 */
	public void setPartId(long partId);

	/**
	 * Returns the user ID of this purchase order.
	 *
	 * @return the user ID of this purchase order
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this purchase order.
	 *
	 * @param userId the user ID of this purchase order
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this purchase order.
	 *
	 * @return the user uuid of this purchase order
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this purchase order.
	 *
	 * @param userUuid the user uuid of this purchase order
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the order date of this purchase order.
	 *
	 * @return the order date of this purchase order
	 */
	public Date getOrderDate();

	/**
	 * Sets the order date of this purchase order.
	 *
	 * @param orderDate the order date of this purchase order
	 */
	public void setOrderDate(Date orderDate);

	/**
	 * Returns the closed of this purchase order.
	 *
	 * @return the closed of this purchase order
	 */
	public boolean getClosed();

	/**
	 * Returns <code>true</code> if this purchase order is closed.
	 *
	 * @return <code>true</code> if this purchase order is closed; <code>false</code> otherwise
	 */
	public boolean isClosed();

	/**
	 * Sets whether this purchase order is closed.
	 *
	 * @param closed the closed of this purchase order
	 */
	public void setClosed(boolean closed);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(PurchaseOrder purchaseOrder);

	public int hashCode();

	public CacheModel<PurchaseOrder> toCacheModel();

	public PurchaseOrder toEscapedModel();

	public String toString();

	public String toXmlString();
}
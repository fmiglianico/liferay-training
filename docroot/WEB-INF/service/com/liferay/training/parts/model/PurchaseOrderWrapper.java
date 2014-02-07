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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PurchaseOrder}.
 * </p>
 *
 * @author    Joe Bloggs
 * @see       PurchaseOrder
 * @generated
 */
public class PurchaseOrderWrapper implements PurchaseOrder,
	ModelWrapper<PurchaseOrder> {
	public PurchaseOrderWrapper(PurchaseOrder purchaseOrder) {
		_purchaseOrder = purchaseOrder;
	}

	public Class<?> getModelClass() {
		return PurchaseOrder.class;
	}

	public String getModelClassName() {
		return PurchaseOrder.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orderId", getOrderId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("partId", getPartId());
		attributes.put("userId", getUserId());
		attributes.put("orderDate", getOrderDate());
		attributes.put("closed", getClosed());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long partId = (Long)attributes.get("partId");

		if (partId != null) {
			setPartId(partId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date orderDate = (Date)attributes.get("orderDate");

		if (orderDate != null) {
			setOrderDate(orderDate);
		}

		Boolean closed = (Boolean)attributes.get("closed");

		if (closed != null) {
			setClosed(closed);
		}
	}

	/**
	* Returns the primary key of this purchase order.
	*
	* @return the primary key of this purchase order
	*/
	public long getPrimaryKey() {
		return _purchaseOrder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this purchase order.
	*
	* @param primaryKey the primary key of this purchase order
	*/
	public void setPrimaryKey(long primaryKey) {
		_purchaseOrder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the order ID of this purchase order.
	*
	* @return the order ID of this purchase order
	*/
	public long getOrderId() {
		return _purchaseOrder.getOrderId();
	}

	/**
	* Sets the order ID of this purchase order.
	*
	* @param orderId the order ID of this purchase order
	*/
	public void setOrderId(long orderId) {
		_purchaseOrder.setOrderId(orderId);
	}

	/**
	* Returns the company ID of this purchase order.
	*
	* @return the company ID of this purchase order
	*/
	public long getCompanyId() {
		return _purchaseOrder.getCompanyId();
	}

	/**
	* Sets the company ID of this purchase order.
	*
	* @param companyId the company ID of this purchase order
	*/
	public void setCompanyId(long companyId) {
		_purchaseOrder.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this purchase order.
	*
	* @return the group ID of this purchase order
	*/
	public long getGroupId() {
		return _purchaseOrder.getGroupId();
	}

	/**
	* Sets the group ID of this purchase order.
	*
	* @param groupId the group ID of this purchase order
	*/
	public void setGroupId(long groupId) {
		_purchaseOrder.setGroupId(groupId);
	}

	/**
	* Returns the part ID of this purchase order.
	*
	* @return the part ID of this purchase order
	*/
	public long getPartId() {
		return _purchaseOrder.getPartId();
	}

	/**
	* Sets the part ID of this purchase order.
	*
	* @param partId the part ID of this purchase order
	*/
	public void setPartId(long partId) {
		_purchaseOrder.setPartId(partId);
	}

	/**
	* Returns the user ID of this purchase order.
	*
	* @return the user ID of this purchase order
	*/
	public long getUserId() {
		return _purchaseOrder.getUserId();
	}

	/**
	* Sets the user ID of this purchase order.
	*
	* @param userId the user ID of this purchase order
	*/
	public void setUserId(long userId) {
		_purchaseOrder.setUserId(userId);
	}

	/**
	* Returns the user uuid of this purchase order.
	*
	* @return the user uuid of this purchase order
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrder.getUserUuid();
	}

	/**
	* Sets the user uuid of this purchase order.
	*
	* @param userUuid the user uuid of this purchase order
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_purchaseOrder.setUserUuid(userUuid);
	}

	/**
	* Returns the order date of this purchase order.
	*
	* @return the order date of this purchase order
	*/
	public java.util.Date getOrderDate() {
		return _purchaseOrder.getOrderDate();
	}

	/**
	* Sets the order date of this purchase order.
	*
	* @param orderDate the order date of this purchase order
	*/
	public void setOrderDate(java.util.Date orderDate) {
		_purchaseOrder.setOrderDate(orderDate);
	}

	/**
	* Returns the closed of this purchase order.
	*
	* @return the closed of this purchase order
	*/
	public boolean getClosed() {
		return _purchaseOrder.getClosed();
	}

	/**
	* Returns <code>true</code> if this purchase order is closed.
	*
	* @return <code>true</code> if this purchase order is closed; <code>false</code> otherwise
	*/
	public boolean isClosed() {
		return _purchaseOrder.isClosed();
	}

	/**
	* Sets whether this purchase order is closed.
	*
	* @param closed the closed of this purchase order
	*/
	public void setClosed(boolean closed) {
		_purchaseOrder.setClosed(closed);
	}

	public boolean isNew() {
		return _purchaseOrder.isNew();
	}

	public void setNew(boolean n) {
		_purchaseOrder.setNew(n);
	}

	public boolean isCachedModel() {
		return _purchaseOrder.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_purchaseOrder.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _purchaseOrder.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _purchaseOrder.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_purchaseOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _purchaseOrder.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_purchaseOrder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PurchaseOrderWrapper((PurchaseOrder)_purchaseOrder.clone());
	}

	public int compareTo(
		com.liferay.training.parts.model.PurchaseOrder purchaseOrder) {
		return _purchaseOrder.compareTo(purchaseOrder);
	}

	@Override
	public int hashCode() {
		return _purchaseOrder.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.training.parts.model.PurchaseOrder> toCacheModel() {
		return _purchaseOrder.toCacheModel();
	}

	public com.liferay.training.parts.model.PurchaseOrder toEscapedModel() {
		return new PurchaseOrderWrapper(_purchaseOrder.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _purchaseOrder.toString();
	}

	public java.lang.String toXmlString() {
		return _purchaseOrder.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_purchaseOrder.persist();
	}

	public java.lang.String getPartName() {
		return _purchaseOrder.getPartName();
	}

	public java.lang.String getPartName(java.util.Locale locale) {
		return _purchaseOrder.getPartName(locale);
	}

	public java.lang.String getPartName(java.lang.String languageId) {
		return _purchaseOrder.getPartName(languageId);
	}

	public void setPartName(java.lang.String partName) {
		_purchaseOrder.setPartName(partName);
	}

	public java.lang.String getPartNumber() {
		return _purchaseOrder.getPartNumber();
	}

	public void setPartNumber(java.lang.String partNumber) {
		_purchaseOrder.setPartNumber(partNumber);
	}

	public java.lang.Long getManufacturerId() {
		return _purchaseOrder.getManufacturerId();
	}

	public void setManufacturerId(java.lang.Long manufacturerId) {
		_purchaseOrder.setManufacturerId(manufacturerId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PurchaseOrder getWrappedPurchaseOrder() {
		return _purchaseOrder;
	}

	public PurchaseOrder getWrappedModel() {
		return _purchaseOrder;
	}

	public void resetOriginalValues() {
		_purchaseOrder.resetOriginalValues();
	}

	private PurchaseOrder _purchaseOrder;
}
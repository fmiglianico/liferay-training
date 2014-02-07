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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.training.parts.service.PurchaseOrderLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joe Bloggs
 */
public class PurchaseOrderClp extends BaseModelImpl<PurchaseOrder>
	implements PurchaseOrder {
	public PurchaseOrderClp() {
	}

	public Class<?> getModelClass() {
		return PurchaseOrder.class;
	}

	public String getModelClassName() {
		return PurchaseOrder.class.getName();
	}

	public long getPrimaryKey() {
		return _orderId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOrderId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_orderId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getPartId() {
		return _partId;
	}

	public void setPartId(long partId) {
		_partId = partId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getOrderDate() {
		return _orderDate;
	}

	public void setOrderDate(Date orderDate) {
		_orderDate = orderDate;
	}

	public boolean getClosed() {
		return _closed;
	}

	public boolean isClosed() {
		return _closed;
	}

	public void setClosed(boolean closed) {
		_closed = closed;
	}

	public java.lang.String getPartName(java.util.Locale locale) {
		throw new UnsupportedOperationException();
	}

	public java.lang.Long getManufacturerId() {
		throw new UnsupportedOperationException();
	}

	public void setManufacturerId(java.lang.Long manufacturerId) {
		throw new UnsupportedOperationException();
	}

	public void setPartName(java.lang.String partName) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getPartName(java.lang.String languageId) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getPartName() {
		throw new UnsupportedOperationException();
	}

	public void setPartNumber(java.lang.String partNumber) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getPartNumber() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getPurchaseOrderRemoteModel() {
		return _purchaseOrderRemoteModel;
	}

	public void setPurchaseOrderRemoteModel(
		BaseModel<?> purchaseOrderRemoteModel) {
		_purchaseOrderRemoteModel = purchaseOrderRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PurchaseOrderLocalServiceUtil.addPurchaseOrder(this);
		}
		else {
			PurchaseOrderLocalServiceUtil.updatePurchaseOrder(this);
		}
	}

	@Override
	public PurchaseOrder toEscapedModel() {
		return (PurchaseOrder)Proxy.newProxyInstance(PurchaseOrder.class.getClassLoader(),
			new Class[] { PurchaseOrder.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PurchaseOrderClp clone = new PurchaseOrderClp();

		clone.setOrderId(getOrderId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setPartId(getPartId());
		clone.setUserId(getUserId());
		clone.setOrderDate(getOrderDate());
		clone.setClosed(getClosed());

		return clone;
	}

	public int compareTo(PurchaseOrder purchaseOrder) {
		int value = 0;

		value = DateUtil.compareTo(getOrderDate(), purchaseOrder.getOrderDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PurchaseOrderClp purchaseOrder = null;

		try {
			purchaseOrder = (PurchaseOrderClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = purchaseOrder.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{orderId=");
		sb.append(getOrderId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", partId=");
		sb.append(getPartId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", orderDate=");
		sb.append(getOrderDate());
		sb.append(", closed=");
		sb.append(getClosed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.training.parts.model.PurchaseOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partId</column-name><column-value><![CDATA[");
		sb.append(getPartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderDate</column-name><column-value><![CDATA[");
		sb.append(getOrderDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closed</column-name><column-value><![CDATA[");
		sb.append(getClosed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orderId;
	private long _companyId;
	private long _groupId;
	private long _partId;
	private long _userId;
	private String _userUuid;
	private Date _orderDate;
	private boolean _closed;
	private BaseModel<?> _purchaseOrderRemoteModel;
}
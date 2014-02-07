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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Joe Bloggs
 * @generated
 */
public class PurchaseOrderSoap implements Serializable {
	public static PurchaseOrderSoap toSoapModel(PurchaseOrder model) {
		PurchaseOrderSoap soapModel = new PurchaseOrderSoap();

		soapModel.setOrderId(model.getOrderId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setPartId(model.getPartId());
		soapModel.setUserId(model.getUserId());
		soapModel.setOrderDate(model.getOrderDate());
		soapModel.setClosed(model.getClosed());

		return soapModel;
	}

	public static PurchaseOrderSoap[] toSoapModels(PurchaseOrder[] models) {
		PurchaseOrderSoap[] soapModels = new PurchaseOrderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseOrderSoap[][] toSoapModels(PurchaseOrder[][] models) {
		PurchaseOrderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseOrderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseOrderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseOrderSoap[] toSoapModels(List<PurchaseOrder> models) {
		List<PurchaseOrderSoap> soapModels = new ArrayList<PurchaseOrderSoap>(models.size());

		for (PurchaseOrder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseOrderSoap[soapModels.size()]);
	}

	public PurchaseOrderSoap() {
	}

	public long getPrimaryKey() {
		return _orderId;
	}

	public void setPrimaryKey(long pk) {
		setOrderId(pk);
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

	private long _orderId;
	private long _companyId;
	private long _groupId;
	private long _partId;
	private long _userId;
	private Date _orderDate;
	private boolean _closed;
}
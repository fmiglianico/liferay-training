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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.liferay.training.parts.model.PurchaseOrder;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PurchaseOrder in entity cache.
 *
 * @author Joe Bloggs
 * @see PurchaseOrder
 * @generated
 */
public class PurchaseOrderCacheModel implements CacheModel<PurchaseOrder>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{orderId=");
		sb.append(orderId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", partId=");
		sb.append(partId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", orderDate=");
		sb.append(orderDate);
		sb.append(", closed=");
		sb.append(closed);
		sb.append("}");

		return sb.toString();
	}

	public PurchaseOrder toEntityModel() {
		PurchaseOrderImpl purchaseOrderImpl = new PurchaseOrderImpl();

		purchaseOrderImpl.setOrderId(orderId);
		purchaseOrderImpl.setCompanyId(companyId);
		purchaseOrderImpl.setGroupId(groupId);
		purchaseOrderImpl.setPartId(partId);
		purchaseOrderImpl.setUserId(userId);

		if (orderDate == Long.MIN_VALUE) {
			purchaseOrderImpl.setOrderDate(null);
		}
		else {
			purchaseOrderImpl.setOrderDate(new Date(orderDate));
		}

		purchaseOrderImpl.setClosed(closed);

		purchaseOrderImpl.resetOriginalValues();

		return purchaseOrderImpl;
	}

	public long orderId;
	public long companyId;
	public long groupId;
	public long partId;
	public long userId;
	public long orderDate;
	public boolean closed;
}
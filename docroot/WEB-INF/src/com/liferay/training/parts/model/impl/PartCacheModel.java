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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.training.parts.model.Part;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Part in entity cache.
 *
 * @author Joe Bloggs
 * @see Part
 * @generated
 */
public class PartCacheModel implements CacheModel<Part>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", partId=");
		sb.append(partId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", manufacturerId=");
		sb.append(manufacturerId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", partNumber=");
		sb.append(partNumber);
		sb.append(", orderDate=");
		sb.append(orderDate);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	public Part toEntityModel() {
		PartImpl partImpl = new PartImpl();

		if (uuid == null) {
			partImpl.setUuid(StringPool.BLANK);
		}
		else {
			partImpl.setUuid(uuid);
		}

		partImpl.setPartId(partId);
		partImpl.setCompanyId(companyId);
		partImpl.setGroupId(groupId);
		partImpl.setUserId(userId);
		partImpl.setManufacturerId(manufacturerId);

		if (name == null) {
			partImpl.setName(StringPool.BLANK);
		}
		else {
			partImpl.setName(name);
		}

		if (partNumber == null) {
			partImpl.setPartNumber(StringPool.BLANK);
		}
		else {
			partImpl.setPartNumber(partNumber);
		}

		if (orderDate == Long.MIN_VALUE) {
			partImpl.setOrderDate(null);
		}
		else {
			partImpl.setOrderDate(new Date(orderDate));
		}

		partImpl.setQuantity(quantity);
		partImpl.setStatus(status);
		partImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			partImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			partImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			partImpl.setStatusDate(null);
		}
		else {
			partImpl.setStatusDate(new Date(statusDate));
		}

		if (userName == null) {
			partImpl.setUserName(StringPool.BLANK);
		}
		else {
			partImpl.setUserName(userName);
		}

		partImpl.resetOriginalValues();

		return partImpl;
	}

	public String uuid;
	public long partId;
	public long companyId;
	public long groupId;
	public long userId;
	public long manufacturerId;
	public String name;
	public String partNumber;
	public long orderDate;
	public int quantity;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String userName;
}
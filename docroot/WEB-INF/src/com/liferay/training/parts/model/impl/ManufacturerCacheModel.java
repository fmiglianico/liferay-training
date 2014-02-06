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

import com.liferay.training.parts.model.Manufacturer;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Manufacturer in entity cache.
 *
 * @author Joe Bloggs
 * @see Manufacturer
 * @generated
 */
public class ManufacturerCacheModel implements CacheModel<Manufacturer>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", manufacturerId=");
		sb.append(manufacturerId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", website=");
		sb.append(website);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
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

	public Manufacturer toEntityModel() {
		ManufacturerImpl manufacturerImpl = new ManufacturerImpl();

		if (uuid == null) {
			manufacturerImpl.setUuid(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setUuid(uuid);
		}

		manufacturerImpl.setManufacturerId(manufacturerId);
		manufacturerImpl.setCompanyId(companyId);
		manufacturerImpl.setGroupId(groupId);
		manufacturerImpl.setUserId(userId);

		if (name == null) {
			manufacturerImpl.setName(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setName(name);
		}

		if (emailAddress == null) {
			manufacturerImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setEmailAddress(emailAddress);
		}

		if (website == null) {
			manufacturerImpl.setWebsite(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setWebsite(website);
		}

		if (phoneNumber == null) {
			manufacturerImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setPhoneNumber(phoneNumber);
		}

		manufacturerImpl.setStatus(status);
		manufacturerImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			manufacturerImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			manufacturerImpl.setStatusDate(null);
		}
		else {
			manufacturerImpl.setStatusDate(new Date(statusDate));
		}

		if (userName == null) {
			manufacturerImpl.setUserName(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setUserName(userName);
		}

		manufacturerImpl.resetOriginalValues();

		return manufacturerImpl;
	}

	public String uuid;
	public long manufacturerId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String emailAddress;
	public String website;
	public String phoneNumber;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String userName;
}
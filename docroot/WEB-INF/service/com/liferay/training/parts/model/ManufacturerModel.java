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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Manufacturer service. Represents a row in the &quot;Inventory_Manufacturer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.training.parts.model.impl.ManufacturerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.training.parts.model.impl.ManufacturerImpl}.
 * </p>
 *
 * @author Joe Bloggs
 * @see Manufacturer
 * @see com.liferay.training.parts.model.impl.ManufacturerImpl
 * @see com.liferay.training.parts.model.impl.ManufacturerModelImpl
 * @generated
 */
public interface ManufacturerModel extends BaseModel<Manufacturer>,
	WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a manufacturer model instance should use the {@link Manufacturer} interface instead.
	 */

	/**
	 * Returns the primary key of this manufacturer.
	 *
	 * @return the primary key of this manufacturer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this manufacturer.
	 *
	 * @param primaryKey the primary key of this manufacturer
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this manufacturer.
	 *
	 * @return the uuid of this manufacturer
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this manufacturer.
	 *
	 * @param uuid the uuid of this manufacturer
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the manufacturer ID of this manufacturer.
	 *
	 * @return the manufacturer ID of this manufacturer
	 */
	public long getManufacturerId();

	/**
	 * Sets the manufacturer ID of this manufacturer.
	 *
	 * @param manufacturerId the manufacturer ID of this manufacturer
	 */
	public void setManufacturerId(long manufacturerId);

	/**
	 * Returns the company ID of this manufacturer.
	 *
	 * @return the company ID of this manufacturer
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this manufacturer.
	 *
	 * @param companyId the company ID of this manufacturer
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this manufacturer.
	 *
	 * @return the group ID of this manufacturer
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this manufacturer.
	 *
	 * @param groupId the group ID of this manufacturer
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this manufacturer.
	 *
	 * @return the user ID of this manufacturer
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this manufacturer.
	 *
	 * @param userId the user ID of this manufacturer
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this manufacturer.
	 *
	 * @return the user uuid of this manufacturer
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this manufacturer.
	 *
	 * @param userUuid the user uuid of this manufacturer
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the name of this manufacturer.
	 *
	 * @return the name of this manufacturer
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this manufacturer.
	 *
	 * @param name the name of this manufacturer
	 */
	public void setName(String name);

	/**
	 * Returns the email address of this manufacturer.
	 *
	 * @return the email address of this manufacturer
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this manufacturer.
	 *
	 * @param emailAddress the email address of this manufacturer
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the website of this manufacturer.
	 *
	 * @return the website of this manufacturer
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this manufacturer.
	 *
	 * @param website the website of this manufacturer
	 */
	public void setWebsite(String website);

	/**
	 * Returns the phone number of this manufacturer.
	 *
	 * @return the phone number of this manufacturer
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this manufacturer.
	 *
	 * @param phoneNumber the phone number of this manufacturer
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the status of this manufacturer.
	 *
	 * @return the status of this manufacturer
	 */
	public int getStatus();

	/**
	 * Sets the status of this manufacturer.
	 *
	 * @param status the status of this manufacturer
	 */
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this manufacturer.
	 *
	 * @return the status by user ID of this manufacturer
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this manufacturer.
	 *
	 * @param statusByUserId the status by user ID of this manufacturer
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this manufacturer.
	 *
	 * @return the status by user uuid of this manufacturer
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this manufacturer.
	 *
	 * @param statusByUserUuid the status by user uuid of this manufacturer
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this manufacturer.
	 *
	 * @return the status by user name of this manufacturer
	 */
	@AutoEscape
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this manufacturer.
	 *
	 * @param statusByUserName the status by user name of this manufacturer
	 */
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this manufacturer.
	 *
	 * @return the status date of this manufacturer
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this manufacturer.
	 *
	 * @param statusDate the status date of this manufacturer
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the user name of this manufacturer.
	 *
	 * @return the user name of this manufacturer
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this manufacturer.
	 *
	 * @param userName the user name of this manufacturer
	 */
	public void setUserName(String userName);

	/**
	 * @deprecated Renamed to {@link #isApproved()}
	 */
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this manufacturer is approved.
	 *
	 * @return <code>true</code> if this manufacturer is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this manufacturer is denied.
	 *
	 * @return <code>true</code> if this manufacturer is denied; <code>false</code> otherwise
	 */
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this manufacturer is a draft.
	 *
	 * @return <code>true</code> if this manufacturer is a draft; <code>false</code> otherwise
	 */
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this manufacturer is expired.
	 *
	 * @return <code>true</code> if this manufacturer is expired; <code>false</code> otherwise
	 */
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this manufacturer is inactive.
	 *
	 * @return <code>true</code> if this manufacturer is inactive; <code>false</code> otherwise
	 */
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this manufacturer is incomplete.
	 *
	 * @return <code>true</code> if this manufacturer is incomplete; <code>false</code> otherwise
	 */
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this manufacturer is pending.
	 *
	 * @return <code>true</code> if this manufacturer is pending; <code>false</code> otherwise
	 */
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this manufacturer is scheduled.
	 *
	 * @return <code>true</code> if this manufacturer is scheduled; <code>false</code> otherwise
	 */
	public boolean isScheduled();

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

	public int compareTo(Manufacturer manufacturer);

	public int hashCode();

	public CacheModel<Manufacturer> toCacheModel();

	public Manufacturer toEscapedModel();

	public String toString();

	public String toXmlString();
}
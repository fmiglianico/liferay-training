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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.model.ManufacturerModel;
import com.liferay.training.parts.model.ManufacturerSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Manufacturer service. Represents a row in the &quot;Inventory_Manufacturer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.training.parts.model.ManufacturerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ManufacturerImpl}.
 * </p>
 *
 * @author Joe Bloggs
 * @see ManufacturerImpl
 * @see com.liferay.training.parts.model.Manufacturer
 * @see com.liferay.training.parts.model.ManufacturerModel
 * @generated
 */
@JSON(strict = true)
public class ManufacturerModelImpl extends BaseModelImpl<Manufacturer>
	implements ManufacturerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a manufacturer model instance should use the {@link com.liferay.training.parts.model.Manufacturer} interface instead.
	 */
	public static final String TABLE_NAME = "Inventory_Manufacturer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "manufacturerId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "emailAddress", Types.VARCHAR },
			{ "website", Types.VARCHAR },
			{ "phoneNumber", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "userName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Inventory_Manufacturer (uuid_ VARCHAR(75) null,manufacturerId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,name VARCHAR(75) null,emailAddress VARCHAR(75) null,website VARCHAR(75) null,phoneNumber VARCHAR(75) null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,userName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Inventory_Manufacturer";
	public static final String ORDER_BY_JPQL = " ORDER BY manufacturer.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Inventory_Manufacturer.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.training.parts.model.Manufacturer"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.training.parts.model.Manufacturer"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.training.parts.model.Manufacturer"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long STATUS_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Manufacturer toModel(ManufacturerSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Manufacturer model = new ManufacturerImpl();

		model.setUuid(soapModel.getUuid());
		model.setManufacturerId(soapModel.getManufacturerId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setName(soapModel.getName());
		model.setEmailAddress(soapModel.getEmailAddress());
		model.setWebsite(soapModel.getWebsite());
		model.setPhoneNumber(soapModel.getPhoneNumber());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setUserName(soapModel.getUserName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Manufacturer> toModels(ManufacturerSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Manufacturer> models = new ArrayList<Manufacturer>(soapModels.length);

		for (ManufacturerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.training.parts.model.Manufacturer"));

	public ManufacturerModelImpl() {
	}

	public long getPrimaryKey() {
		return _manufacturerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setManufacturerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_manufacturerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Manufacturer.class;
	}

	public String getModelClassName() {
		return Manufacturer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("manufacturerId", getManufacturerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("website", getWebsite());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long manufacturerId = (Long)attributes.get("manufacturerId");

		if (manufacturerId != null) {
			setManufacturerId(manufacturerId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getManufacturerId() {
		return _manufacturerId;
	}

	public void setManufacturerId(long manufacturerId) {
		_manufacturerId = manufacturerId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
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

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@JSON
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailAddress;
		}
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@JSON
	public String getWebsite() {
		if (_website == null) {
			return StringPool.BLANK;
		}
		else {
			return _website;
		}
	}

	public void setWebsite(String website) {
		_website = website;
	}

	@JSON
	public String getPhoneNumber() {
		if (_phoneNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _phoneNumber;
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	@JSON
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@JSON
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	/**
	 * @deprecated {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if ((getStatus() == WorkflowConstants.STATUS_DRAFT) ||
				(getStatus() == WorkflowConstants.STATUS_DRAFT_FROM_APPROVED)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Manufacturer.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Manufacturer toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Manufacturer)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ManufacturerImpl manufacturerImpl = new ManufacturerImpl();

		manufacturerImpl.setUuid(getUuid());
		manufacturerImpl.setManufacturerId(getManufacturerId());
		manufacturerImpl.setCompanyId(getCompanyId());
		manufacturerImpl.setGroupId(getGroupId());
		manufacturerImpl.setUserId(getUserId());
		manufacturerImpl.setName(getName());
		manufacturerImpl.setEmailAddress(getEmailAddress());
		manufacturerImpl.setWebsite(getWebsite());
		manufacturerImpl.setPhoneNumber(getPhoneNumber());
		manufacturerImpl.setStatus(getStatus());
		manufacturerImpl.setStatusByUserId(getStatusByUserId());
		manufacturerImpl.setStatusByUserName(getStatusByUserName());
		manufacturerImpl.setStatusDate(getStatusDate());
		manufacturerImpl.setUserName(getUserName());

		manufacturerImpl.resetOriginalValues();

		return manufacturerImpl;
	}

	public int compareTo(Manufacturer manufacturer) {
		int value = 0;

		value = getName().compareTo(manufacturer.getName());

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

		Manufacturer manufacturer = null;

		try {
			manufacturer = (Manufacturer)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = manufacturer.getPrimaryKey();

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
	public void resetOriginalValues() {
		ManufacturerModelImpl manufacturerModelImpl = this;

		manufacturerModelImpl._originalUuid = manufacturerModelImpl._uuid;

		manufacturerModelImpl._originalGroupId = manufacturerModelImpl._groupId;

		manufacturerModelImpl._setOriginalGroupId = false;

		manufacturerModelImpl._originalStatus = manufacturerModelImpl._status;

		manufacturerModelImpl._setOriginalStatus = false;

		manufacturerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Manufacturer> toCacheModel() {
		ManufacturerCacheModel manufacturerCacheModel = new ManufacturerCacheModel();

		manufacturerCacheModel.uuid = getUuid();

		String uuid = manufacturerCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			manufacturerCacheModel.uuid = null;
		}

		manufacturerCacheModel.manufacturerId = getManufacturerId();

		manufacturerCacheModel.companyId = getCompanyId();

		manufacturerCacheModel.groupId = getGroupId();

		manufacturerCacheModel.userId = getUserId();

		manufacturerCacheModel.name = getName();

		String name = manufacturerCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			manufacturerCacheModel.name = null;
		}

		manufacturerCacheModel.emailAddress = getEmailAddress();

		String emailAddress = manufacturerCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			manufacturerCacheModel.emailAddress = null;
		}

		manufacturerCacheModel.website = getWebsite();

		String website = manufacturerCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			manufacturerCacheModel.website = null;
		}

		manufacturerCacheModel.phoneNumber = getPhoneNumber();

		String phoneNumber = manufacturerCacheModel.phoneNumber;

		if ((phoneNumber != null) && (phoneNumber.length() == 0)) {
			manufacturerCacheModel.phoneNumber = null;
		}

		manufacturerCacheModel.status = getStatus();

		manufacturerCacheModel.statusByUserId = getStatusByUserId();

		manufacturerCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = manufacturerCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			manufacturerCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			manufacturerCacheModel.statusDate = statusDate.getTime();
		}
		else {
			manufacturerCacheModel.statusDate = Long.MIN_VALUE;
		}

		manufacturerCacheModel.userName = getUserName();

		String userName = manufacturerCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			manufacturerCacheModel.userName = null;
		}

		return manufacturerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", manufacturerId=");
		sb.append(getManufacturerId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.training.parts.model.Manufacturer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manufacturerId</column-name><column-value><![CDATA[");
		sb.append(getManufacturerId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Manufacturer.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Manufacturer.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _manufacturerId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _emailAddress;
	private String _website;
	private String _phoneNumber;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private String _userName;
	private long _columnBitmask;
	private Manufacturer _escapedModelProxy;
}
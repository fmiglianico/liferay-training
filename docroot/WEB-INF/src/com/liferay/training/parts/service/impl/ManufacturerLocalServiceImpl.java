/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.training.parts.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.service.base.ManufacturerLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the manufacturer local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.parts.service.ManufacturerLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.liferay.training.parts.service.ManufacturerLocalServiceUtil} to
 * access the manufacturer local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Joe Bloggs
 * @see com.liferay.training.parts.service.base.ManufacturerLocalServiceBaseImpl
 * @see com.liferay.training.parts.service.ManufacturerLocalServiceUtil
 */
public class ManufacturerLocalServiceImpl extends
		ManufacturerLocalServiceBaseImpl {

	/**
	 * Adds the Manufacturer to the database incrementing the primary key
	 * 
	 * @throws PortalException
	 * 
	 */
	public Manufacturer addManufacturer(Manufacturer newManufacturer,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		long manufacturerId = counterLocalService.increment(Manufacturer.class
				.getName());

		long userId = serviceContext.getUserId();
		User user = UserLocalServiceUtil.getUser(userId);

		Manufacturer manufacturer = manufacturerPersistence
				.create(manufacturerId);

		manufacturer.setUserName(user.getFullName());
		manufacturer.setCompanyId(newManufacturer.getCompanyId());
		manufacturer.setUserId(userId);
		manufacturer.setEmailAddress(newManufacturer.getEmailAddress());
		manufacturer.setGroupId(newManufacturer.getGroupId());
		manufacturer.setName(newManufacturer.getName());
		manufacturer.setPhoneNumber(newManufacturer.getPhoneNumber());
		manufacturer.setWebsite(newManufacturer.getWebsite());
		manufacturer.setUuid(newManufacturer.getUuid());
		manufacturer.setStatus(WorkflowConstants.STATUS_DRAFT);

		manufacturerPersistence.update(manufacturer, false, serviceContext);

		resourceLocalService
				.addResources(manufacturer.getCompanyId(),
						manufacturer.getGroupId(), userId,
						Manufacturer.class.getName(), manufacturerId, false,
						true, true);

		assetEntryLocalService.updateEntry(userId, manufacturer.getGroupId(),
				Manufacturer.class.getName(), manufacturer.getManufacturerId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				manufacturer.getCompanyId(), manufacturer.getGroupId(), userId,
				Manufacturer.class.getName(), manufacturer.getPrimaryKey(), manufacturer,
				serviceContext);
	    
		return manufacturer;
	}

	/**
	 * Deletes a manufacturer from the database using the Manufacturer object.
	 */
	public Manufacturer deleteManufacturer(Manufacturer manufacturer)
			throws PortalException, SystemException {

		resourceLocalService.deleteResource(manufacturer.getCompanyId(),
				Manufacturer.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL,
				manufacturer.getPrimaryKey());

		assetEntryLocalService.deleteEntry(Manufacturer.class.getName(),
				manufacturer.getManufacturerId());

		return super.deleteManufacturer(manufacturer);
	}

	/**
	 * Deletes a manufacturer from the database using a manufacturer ID.
	 */
	public Manufacturer deleteManufacturer(long manufacturerId)
			throws PortalException, SystemException {

		Manufacturer manufacturer = getManufacturer(manufacturerId);

		return deleteManufacturer(manufacturer);
	}

	/**
	 * Gets a list with all the Manufacturers in a group
	 * 
	 */
	public List<Manufacturer> getManufacturersByGroupId(long groupId)
			throws SystemException {
		return manufacturerPersistence.filterFindByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}

	/**
	 * Gets a list with a range of Manufacturers from a group
	 * 
	 */
	public List<Manufacturer> getManufacturersByGroupId(long groupId,
			int start, int end) throws SystemException {
		return manufacturerPersistence.filterFindByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
	}

	/**
	 * Gets the number of Manufacturers in a group
	 * 
	 */
	public int getManufacturersCountByGroupId(long groupId)
			throws SystemException {
		return manufacturerPersistence.filterCountByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}

	public Manufacturer updateManufacturer(Manufacturer editedManufacturer,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		Manufacturer manufacturer = super
				.updateManufacturer(editedManufacturer);

		long userId = serviceContext.getUserId();

		assetEntryLocalService.updateEntry(userId, manufacturer.getGroupId(),
				Manufacturer.class.getName(), manufacturer.getManufacturerId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());

		return manufacturer;

	}

	public Manufacturer updateStatus(long userId, long manufacturerId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {

		User user = userLocalService.getUser(userId);
		Manufacturer mfg = getManufacturer(manufacturerId);

		mfg.setStatus(status);
		mfg.setStatusByUserId(userId);
		mfg.setStatusByUserName(user.getFullName());
		mfg.setStatusDate(serviceContext.getModifiedDate());

		manufacturerPersistence.update(mfg, false);

		if (status == WorkflowConstants.STATUS_APPROVED) {

			assetEntryLocalService.updateVisible(Manufacturer.class.getName(),
					manufacturerId, true);

		} else {

			assetEntryLocalService.updateVisible(Manufacturer.class.getName(),
					manufacturerId, false);
		}

		return mfg;
	}

}

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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.service.base.PartLocalServiceBaseImpl;
import com.liferay.training.parts.social.PartActivityKeys;

import java.util.List;

/**
 * The implementation of the part local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.parts.service.PartLocalService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.liferay.training.parts.service.PartLocalServiceUtil} to access the
 * part local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Joe Bloggs
 * @see com.liferay.training.parts.service.base.PartLocalServiceBaseImpl
 * @see com.liferay.training.parts.service.PartLocalServiceUtil
 */
public class PartLocalServiceImpl extends PartLocalServiceBaseImpl {
	/**
	 * Adds the Part to the database incrementing the primary key
	 * 
	 * @throws PortalException
	 * 
	 */
	public Part addPart(Part newPart, ServiceContext serviceContext) throws SystemException,
			PortalException {
		long partId = counterLocalService.increment(Part.class.getName());
		long userId = serviceContext.getUserId();

		Part part = partPersistence.create(partId);
		part.setPartNumber(newPart.getPartNumber());
		part.setCompanyId(newPart.getCompanyId());
		part.setGroupId(newPart.getGroupId());
		part.setUserId(newPart.getUserId());
		part.setOrderDate(newPart.getOrderDate());
		part.setQuantity(newPart.getQuantity());
		part.setManufacturerId(newPart.getManufacturerId());
		part.setName(newPart.getName());
		part.setUuid(newPart.getUuid());

		resourceLocalService.addResources(part.getCompanyId(),
				part.getGroupId(), userId, Part.class.getName(), partId, false,
				true, true);
		
		socialActivityLocalService.addActivity(userId, part.getGroupId(), 
						Part.class.getName(), part.getPartId(), 
						PartActivityKeys.ADD_PART, StringPool.BLANK, 0);

		return partPersistence.update(part, false);

	}
	    

	public Part deletePart(Part part)
			throws PortalException, SystemException {

		resourceLocalService.deleteResource(part.getCompanyId(),
				Part.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				part.getPrimaryKey());
		
		socialActivityLocalService.deleteActivities(Part.class.getName(), part.getPartId());

		return super.deletePart(part);

	}
	    

	public Part deletePart(long partId) throws PortalException, SystemException {

		Part part = partLocalService.getPart(partId);

		return deletePart(part);
	}

	/**
	 * Gets a list with all the Parts in a group
	 * 
	 */
	public List<Part> getPartsByGroupId(long groupId) throws SystemException {
		return partPersistence.filterFindByGroupId(groupId);
	}

	/**
	 * Gets a list with a range of Parts from a group
	 * 
	 */
	public List<Part> getPartsByGroupId(long groupId, int start, int end)
			throws SystemException {
		return partPersistence.filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Gets the number of Parts in a group
	 * 
	 */
	public int getPartsCountByGroupId(long groupId) throws SystemException {
		return partPersistence.filterCountByGroupId(groupId);
	}

	/**
	 * Gets a list of Parts from a Manufacturer in a group
	 * 
	 */
	public List<Part> getPartsByManufacturer(long manufacturerId, long groupId)
			throws SystemException {
		return partPersistence.findByManufacturer(manufacturerId, groupId);
	}

}
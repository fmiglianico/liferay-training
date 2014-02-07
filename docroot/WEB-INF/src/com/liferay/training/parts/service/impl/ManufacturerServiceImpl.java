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

package com.liferay.training.parts.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.model.impl.ManufacturerImpl;
import com.liferay.training.parts.service.base.ManufacturerServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the manufacturer remote service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.parts.service.ManufacturerService} interface. <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely. </p>
 * 
 * @author Joe Bloggs
 * @see com.liferay.training.parts.service.base.ManufacturerServiceBaseImpl
 * @see com.liferay.training.parts.service.ManufacturerServiceUtil
 */
public class ManufacturerServiceImpl extends ManufacturerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.liferay.training.parts.service.ManufacturerServiceUtil} to
	 * access the manufacturer remote service.
	 */
	
		/**
	 * Adds the Manufacturer to the database incrementing the primary key
	 * 
	 * @throws PortalException
	 * 
	 */
	public Manufacturer addManufacturer(long companyId, long groupId,
			long userId, String name, String emailAddress, String phoneNumber,
			String website) throws SystemException, PortalException {

				if (!getPermissionChecker().hasPermission(groupId,
				"com.liferay.training.parts.model", groupId, "ADD_MANUFACTURER")) {
			throw new PrincipalException();
		}
		

		Manufacturer manufacturer = new ManufacturerImpl();
		manufacturer.setCompanyId(companyId);
		manufacturer.setGroupId(groupId);
		manufacturer.setUserId(userId);
		manufacturer.setName(name);
		manufacturer.setEmailAddress(emailAddress);
		manufacturer.setPhoneNumber(phoneNumber);
		manufacturer.setWebsite(website);
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(companyId);
		serviceContext.setUserId(userId);
		serviceContext.setScopeGroupId(groupId);

		return manufacturerLocalService.addManufacturer(manufacturer, serviceContext);

	}

	/**
	 * Deletes a manufacturer from the database using the Manufacturer object.
	 */
	public void deleteManufacturer(long groupId, long manufacturerId)
			throws PortalException, SystemException {

				if (!getPermissionChecker().hasPermission(groupId,
				Manufacturer.class.getName(), groupId, "DELETE")) {
			throw new PrincipalException();
		}


		manufacturerLocalService.deleteManufacturer(manufacturerId);
	}

	/**
	 * Gets a Manufacturer by groupId and manufacturerId
	 * 
	 */
	public Manufacturer getManufacturer(long groupId, long manufacturerId)
			throws PortalException, SystemException {

/*		if (!getPermissionChecker().hasPermission(groupId,
				Manufacturer.class.getName(), groupId, "VIEW")) {
			throw new PrincipalException();
		}
*/

		return manufacturerLocalService.getManufacturer(manufacturerId);
	}

	/**
	 * Gets a list with all the Manufacturers in a group
	 * 
	 */
	public List<Manufacturer> getManufacturersByGroupId(long groupId)
			throws SystemException {

		return manufacturerLocalService.getManufacturersByGroupId(groupId);

	}
}

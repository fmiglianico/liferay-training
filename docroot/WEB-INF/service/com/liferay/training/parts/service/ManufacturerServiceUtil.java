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

package com.liferay.training.parts.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the manufacturer remote service. This utility wraps {@link com.liferay.training.parts.service.impl.ManufacturerServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Joe Bloggs
 * @see ManufacturerService
 * @see com.liferay.training.parts.service.base.ManufacturerServiceBaseImpl
 * @see com.liferay.training.parts.service.impl.ManufacturerServiceImpl
 * @generated
 */
public class ManufacturerServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.parts.service.impl.ManufacturerServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Adds the Manufacturer to the database incrementing the primary key
	*
	* @throws PortalException
	*/
	public static com.liferay.training.parts.model.Manufacturer addManufacturer(
		long companyId, long groupId, long userId, java.lang.String name,
		java.lang.String emailAddress, java.lang.String phoneNumber,
		java.lang.String website)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addManufacturer(companyId, groupId, userId, name,
			emailAddress, phoneNumber, website);
	}

	/**
	* Deletes a manufacturer from the database using the Manufacturer object.
	*/
	public static void deleteManufacturer(long groupId, long manufacturerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteManufacturer(groupId, manufacturerId);
	}

	/**
	* Gets a Manufacturer by groupId and manufacturerId
	*/
	public static com.liferay.training.parts.model.Manufacturer getManufacturer(
		long groupId, long manufacturerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getManufacturer(groupId, manufacturerId);
	}

	/**
	* Gets a list with all the Manufacturers in a group
	*/
	public static java.util.List<com.liferay.training.parts.model.Manufacturer> getManufacturersByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManufacturersByGroupId(groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ManufacturerService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ManufacturerService.class.getName());

			if (invokableService instanceof ManufacturerService) {
				_service = (ManufacturerService)invokableService;
			}
			else {
				_service = new ManufacturerServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ManufacturerServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ManufacturerService service) {
	}

	private static ManufacturerService _service;
}
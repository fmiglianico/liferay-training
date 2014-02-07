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

package com.liferay.training.parts.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Joe Bloggs
 */
public class PurchaseOrderFinderUtil {
	public static int countByPart(long partId, boolean useCustomSQL)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByPart(partId, useCustomSQL);
	}

	public static int countByUser(long userId, long companyId, long groupId,
		boolean useCustomSQL)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByUser(userId, companyId, groupId, useCustomSQL);
	}

	public static java.util.List<com.liferay.training.parts.model.PurchaseOrder> findByUser(
		long userId, long companyId, long groupId, boolean useCustomSQL,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByUser(userId, companyId, groupId, useCustomSQL, start,
			end);
	}

	public static PurchaseOrderFinder getFinder() {
		if (_finder == null) {
			_finder = (PurchaseOrderFinder)PortletBeanLocatorUtil.locate(com.liferay.training.parts.service.ClpSerializer.getServletContextName(),
					PurchaseOrderFinder.class.getName());

			ReferenceRegistry.registerReference(PurchaseOrderFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PurchaseOrderFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PurchaseOrderFinderUtil.class,
			"_finder");
	}

	private static PurchaseOrderFinder _finder;
}
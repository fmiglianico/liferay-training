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
import com.liferay.training.parts.model.PurchaseOrder;
import com.liferay.training.parts.model.impl.PurchaseOrderImpl;
import com.liferay.training.parts.service.base.PurchaseOrderLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the purchase order local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.parts.service.PurchaseOrderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Joe Bloggs
 * @see com.liferay.training.parts.service.base.PurchaseOrderLocalServiceBaseImpl
 * @see com.liferay.training.parts.service.PurchaseOrderLocalServiceUtil
 */
public class PurchaseOrderLocalServiceImpl
	extends PurchaseOrderLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.training.parts.service.PurchaseOrderLocalServiceUtil} to access the purchase order local service.
	 */
		public void orderPart(long partId, long userId, long companyId, long groupId) throws SystemException, PortalException {

		long purchaseOrderId = counterLocalService.increment(PurchaseOrder.class.getName());

		PurchaseOrder purchaseOrder = new PurchaseOrderImpl();

		purchaseOrder.setOrderId(purchaseOrderId);
		purchaseOrder.setPartId(partId);
		purchaseOrder.setUserId(userId);
		purchaseOrder.setCompanyId(companyId);
		purchaseOrder.setGroupId(groupId);
		purchaseOrder.setClosed(false);
		purchaseOrder.setOrderDate(new Date());
		addPurchaseOrder(purchaseOrder);
		
		partLocalService.updateInventory(partId, -1);
	}
public int countByPart(long partId, boolean useCustomSQL) throws PortalException, SystemException {
		return purchaseOrderFinder.countByPart(partId, useCustomSQL);
	}

	public List<PurchaseOrder> findByUser(long userId, long companyId, long groupId, boolean useCustomSQL, int start, int end)
	throws PortalException, SystemException {
		return purchaseOrderFinder.findByUser(userId, companyId, groupId, useCustomSQL, start, end);
	}

	public int countByUser(long userId, long companyId, long groupId, boolean useCustomSQL) throws PortalException, SystemException {
		return purchaseOrderFinder.countByUser(userId, companyId, groupId, useCustomSQL);
	}

	
	
}
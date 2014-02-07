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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.training.parts.model.PurchaseOrder;

import java.util.List;

/**
 * The persistence utility for the purchase order service. This utility wraps {@link PurchaseOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see PurchaseOrderPersistence
 * @see PurchaseOrderPersistenceImpl
 * @generated
 */
public class PurchaseOrderUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PurchaseOrder purchaseOrder) {
		getPersistence().clearCache(purchaseOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PurchaseOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PurchaseOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PurchaseOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PurchaseOrder update(PurchaseOrder purchaseOrder,
		boolean merge) throws SystemException {
		return getPersistence().update(purchaseOrder, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PurchaseOrder update(PurchaseOrder purchaseOrder,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(purchaseOrder, merge, serviceContext);
	}

	/**
	* Caches the purchase order in the entity cache if it is enabled.
	*
	* @param purchaseOrder the purchase order
	*/
	public static void cacheResult(
		com.liferay.training.parts.model.PurchaseOrder purchaseOrder) {
		getPersistence().cacheResult(purchaseOrder);
	}

	/**
	* Caches the purchase orders in the entity cache if it is enabled.
	*
	* @param purchaseOrders the purchase orders
	*/
	public static void cacheResult(
		java.util.List<com.liferay.training.parts.model.PurchaseOrder> purchaseOrders) {
		getPersistence().cacheResult(purchaseOrders);
	}

	/**
	* Creates a new purchase order with the primary key. Does not add the purchase order to the database.
	*
	* @param orderId the primary key for the new purchase order
	* @return the new purchase order
	*/
	public static com.liferay.training.parts.model.PurchaseOrder create(
		long orderId) {
		return getPersistence().create(orderId);
	}

	/**
	* Removes the purchase order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the purchase order
	* @return the purchase order that was removed
	* @throws com.liferay.training.parts.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.parts.model.PurchaseOrder remove(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPurchaseOrderException {
		return getPersistence().remove(orderId);
	}

	public static com.liferay.training.parts.model.PurchaseOrder updateImpl(
		com.liferay.training.parts.model.PurchaseOrder purchaseOrder,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(purchaseOrder, merge);
	}

	/**
	* Returns the purchase order with the primary key or throws a {@link com.liferay.training.parts.NoSuchPurchaseOrderException} if it could not be found.
	*
	* @param orderId the primary key of the purchase order
	* @return the purchase order
	* @throws com.liferay.training.parts.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.parts.model.PurchaseOrder findByPrimaryKey(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPurchaseOrderException {
		return getPersistence().findByPrimaryKey(orderId);
	}

	/**
	* Returns the purchase order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderId the primary key of the purchase order
	* @return the purchase order, or <code>null</code> if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.parts.model.PurchaseOrder fetchByPrimaryKey(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orderId);
	}

	/**
	* Returns all the purchase orders.
	*
	* @return the purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.parts.model.PurchaseOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the purchase orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of purchase orders
	* @param end the upper bound of the range of purchase orders (not inclusive)
	* @return the range of purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.parts.model.PurchaseOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the purchase orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of purchase orders
	* @param end the upper bound of the range of purchase orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.parts.model.PurchaseOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the purchase orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of purchase orders.
	*
	* @return the number of purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PurchaseOrderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PurchaseOrderPersistence)PortletBeanLocatorUtil.locate(com.liferay.training.parts.service.ClpSerializer.getServletContextName(),
					PurchaseOrderPersistence.class.getName());

			ReferenceRegistry.registerReference(PurchaseOrderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PurchaseOrderPersistence persistence) {
	}

	private static PurchaseOrderPersistence _persistence;
}
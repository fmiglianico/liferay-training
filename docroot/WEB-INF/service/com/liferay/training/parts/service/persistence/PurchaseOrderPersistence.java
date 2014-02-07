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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.training.parts.model.PurchaseOrder;

/**
 * The persistence interface for the purchase order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see PurchaseOrderPersistenceImpl
 * @see PurchaseOrderUtil
 * @generated
 */
public interface PurchaseOrderPersistence extends BasePersistence<PurchaseOrder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PurchaseOrderUtil} to access the purchase order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the purchase order in the entity cache if it is enabled.
	*
	* @param purchaseOrder the purchase order
	*/
	public void cacheResult(
		com.liferay.training.parts.model.PurchaseOrder purchaseOrder);

	/**
	* Caches the purchase orders in the entity cache if it is enabled.
	*
	* @param purchaseOrders the purchase orders
	*/
	public void cacheResult(
		java.util.List<com.liferay.training.parts.model.PurchaseOrder> purchaseOrders);

	/**
	* Creates a new purchase order with the primary key. Does not add the purchase order to the database.
	*
	* @param orderId the primary key for the new purchase order
	* @return the new purchase order
	*/
	public com.liferay.training.parts.model.PurchaseOrder create(long orderId);

	/**
	* Removes the purchase order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the purchase order
	* @return the purchase order that was removed
	* @throws com.liferay.training.parts.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.PurchaseOrder remove(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPurchaseOrderException;

	public com.liferay.training.parts.model.PurchaseOrder updateImpl(
		com.liferay.training.parts.model.PurchaseOrder purchaseOrder,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the purchase order with the primary key or throws a {@link com.liferay.training.parts.NoSuchPurchaseOrderException} if it could not be found.
	*
	* @param orderId the primary key of the purchase order
	* @return the purchase order
	* @throws com.liferay.training.parts.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.PurchaseOrder findByPrimaryKey(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPurchaseOrderException;

	/**
	* Returns the purchase order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderId the primary key of the purchase order
	* @return the purchase order, or <code>null</code> if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.PurchaseOrder fetchByPrimaryKey(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the purchase orders.
	*
	* @return the purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.PurchaseOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.training.parts.model.PurchaseOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.training.parts.model.PurchaseOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the purchase orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of purchase orders.
	*
	* @return the number of purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
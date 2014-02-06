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

import com.liferay.training.parts.model.Manufacturer;

/**
 * The persistence interface for the manufacturer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see ManufacturerPersistenceImpl
 * @see ManufacturerUtil
 * @generated
 */
public interface ManufacturerPersistence extends BasePersistence<Manufacturer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ManufacturerUtil} to access the manufacturer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the manufacturer in the entity cache if it is enabled.
	*
	* @param manufacturer the manufacturer
	*/
	public void cacheResult(
		com.liferay.training.parts.model.Manufacturer manufacturer);

	/**
	* Caches the manufacturers in the entity cache if it is enabled.
	*
	* @param manufacturers the manufacturers
	*/
	public void cacheResult(
		java.util.List<com.liferay.training.parts.model.Manufacturer> manufacturers);

	/**
	* Creates a new manufacturer with the primary key. Does not add the manufacturer to the database.
	*
	* @param manufacturerId the primary key for the new manufacturer
	* @return the new manufacturer
	*/
	public com.liferay.training.parts.model.Manufacturer create(
		long manufacturerId);

	/**
	* Removes the manufacturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param manufacturerId the primary key of the manufacturer
	* @return the manufacturer that was removed
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer remove(
		long manufacturerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	public com.liferay.training.parts.model.Manufacturer updateImpl(
		com.liferay.training.parts.model.Manufacturer manufacturer,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the manufacturer with the primary key or throws a {@link com.liferay.training.parts.NoSuchManufacturerException} if it could not be found.
	*
	* @param manufacturerId the primary key of the manufacturer
	* @return the manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer findByPrimaryKey(
		long manufacturerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the manufacturer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param manufacturerId the primary key of the manufacturer
	* @return the manufacturer, or <code>null</code> if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByPrimaryKey(
		long manufacturerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the manufacturers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the manufacturers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @return the range of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the manufacturers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first manufacturer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the first manufacturer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last manufacturer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the last manufacturer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the manufacturers before and after the current manufacturer in the ordered set where uuid = &#63;.
	*
	* @param manufacturerId the primary key of the current manufacturer
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer[] findByUuid_PrevAndNext(
		long manufacturerId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the manufacturer where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.training.parts.NoSuchManufacturerException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the manufacturer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the manufacturer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the manufacturers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the manufacturers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @return the range of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the manufacturers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first manufacturer in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the first manufacturer in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last manufacturer in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the last manufacturer in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the manufacturers before and after the current manufacturer in the ordered set where groupId = &#63;.
	*
	* @param manufacturerId the primary key of the current manufacturer
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer[] findByGroupId_PrevAndNext(
		long manufacturerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns all the manufacturers that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching manufacturers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the manufacturers that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @return the range of matching manufacturers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the manufacturers that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching manufacturers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the manufacturers before and after the current manufacturer in the ordered set of manufacturers that the user has permission to view where groupId = &#63;.
	*
	* @param manufacturerId the primary key of the current manufacturer
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer[] filterFindByGroupId_PrevAndNext(
		long manufacturerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns all the manufacturers where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the manufacturers where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @return the range of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the manufacturers where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first manufacturer in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer findByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the first manufacturer in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last manufacturer in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer findByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns the last manufacturer in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the manufacturers before and after the current manufacturer in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param manufacturerId the primary key of the current manufacturer
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer[] findByG_S_PrevAndNext(
		long manufacturerId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns all the manufacturers that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching manufacturers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> filterFindByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the manufacturers that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @return the range of matching manufacturers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> filterFindByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the manufacturers that the user has permissions to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching manufacturers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the manufacturers before and after the current manufacturer in the ordered set of manufacturers that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param manufacturerId the primary key of the current manufacturer
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next manufacturer
	* @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer[] filterFindByG_S_PrevAndNext(
		long manufacturerId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Returns all the manufacturers.
	*
	* @return the manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the manufacturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @return the range of manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the manufacturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Manufacturer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the manufacturers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the manufacturer where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the manufacturer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Manufacturer removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchManufacturerException;

	/**
	* Removes all the manufacturers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the manufacturers where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the manufacturers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of manufacturers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of manufacturers where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of manufacturers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of manufacturers that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching manufacturers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of manufacturers where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of manufacturers that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching manufacturers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of manufacturers.
	*
	* @return the number of manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
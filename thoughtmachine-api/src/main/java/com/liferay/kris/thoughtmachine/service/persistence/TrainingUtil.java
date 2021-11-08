/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.kris.thoughtmachine.service.persistence;

import com.liferay.kris.thoughtmachine.model.Training;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the training service. This utility wraps <code>com.liferay.kris.thoughtmachine.service.persistence.impl.TrainingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingPersistence
 * @generated
 */
public class TrainingUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Training training) {
		getPersistence().clearCache(training);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Training> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Training> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Training> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Training> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Training update(Training training) {
		return getPersistence().update(training);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Training update(
		Training training, ServiceContext serviceContext) {

		return getPersistence().update(training, serviceContext);
	}

	/**
	 * Returns all the trainings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainings
	 */
	public static List<Training> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trainings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of matching trainings
	 */
	public static List<Training> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trainings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByUuid_First(
			String uuid, OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByUuid_First(
		String uuid, OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByUuid_Last(
			String uuid, OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByUuid_Last(
		String uuid, OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trainings before and after the current training in the ordered set where uuid = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training[] findByUuid_PrevAndNext(
			long trainingId, String uuid,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByUuid_PrevAndNext(
			trainingId, uuid, orderByComparator);
	}

	/**
	 * Removes all the trainings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trainings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTrainingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByUUID_G(String uuid, long groupId)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the training where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the training that was removed
	 */
	public static Training removeByUUID_G(String uuid, long groupId)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of trainings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainings
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainings
	 */
	public static List<Training> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of matching trainings
	 */
	public static List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the trainings before and after the current training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training[] findByUuid_C_PrevAndNext(
			long trainingId, String uuid, long companyId,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByUuid_C_PrevAndNext(
			trainingId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the trainings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainings
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the trainings where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	public static List<Training> findByOrganisation(long organisation) {
		return getPersistence().findByOrganisation(organisation);
	}

	/**
	 * Returns a range of all the trainings where organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of matching trainings
	 */
	public static List<Training> findByOrganisation(
		long organisation, int start, int end) {

		return getPersistence().findByOrganisation(organisation, start, end);
	}

	/**
	 * Returns an ordered range of all the trainings where organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByOrganisation(
		long organisation, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().findByOrganisation(
			organisation, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainings where organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByOrganisation(
		long organisation, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByOrganisation(
			organisation, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByOrganisation_First(
			long organisation, OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByOrganisation_First(
			organisation, orderByComparator);
	}

	/**
	 * Returns the first training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByOrganisation_First(
		long organisation, OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByOrganisation_First(
			organisation, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByOrganisation_Last(
			long organisation, OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByOrganisation_Last(
			organisation, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByOrganisation_Last(
		long organisation, OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByOrganisation_Last(
			organisation, orderByComparator);
	}

	/**
	 * Returns the trainings before and after the current training in the ordered set where organisation = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training[] findByOrganisation_PrevAndNext(
			long trainingId, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByOrganisation_PrevAndNext(
			trainingId, organisation, orderByComparator);
	}

	/**
	 * Removes all the trainings where organisation = &#63; from the database.
	 *
	 * @param organisation the organisation
	 */
	public static void removeByOrganisation(long organisation) {
		getPersistence().removeByOrganisation(organisation);
	}

	/**
	 * Returns the number of trainings where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	public static int countByOrganisation(long organisation) {
		return getPersistence().countByOrganisation(organisation);
	}

	/**
	 * Returns all the trainings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching trainings
	 */
	public static List<Training> findByByUser(long userId) {
		return getPersistence().findByByUser(userId);
	}

	/**
	 * Returns a range of all the trainings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of matching trainings
	 */
	public static List<Training> findByByUser(long userId, int start, int end) {
		return getPersistence().findByByUser(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByByUser(
		long userId, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().findByByUser(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByByUser(
		long userId, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByByUser(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByByUser_First(
			long userId, OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the first training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByByUser_First(
		long userId, OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByByUser_Last(
			long userId, OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByByUser_Last(
		long userId, OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the trainings before and after the current training in the ordered set where userId = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training[] findByByUser_PrevAndNext(
			long trainingId, long userId,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByByUser_PrevAndNext(
			trainingId, userId, orderByComparator);
	}

	/**
	 * Removes all the trainings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByByUser(long userId) {
		getPersistence().removeByByUser(userId);
	}

	/**
	 * Returns the number of trainings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching trainings
	 */
	public static int countByByUser(long userId) {
		return getPersistence().countByByUser(userId);
	}

	/**
	 * Returns all the trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @return the matching trainings
	 */
	public static List<Training> findByByUserStatus(
		long userId, String courseStatus) {

		return getPersistence().findByByUserStatus(userId, courseStatus);
	}

	/**
	 * Returns a range of all the trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of matching trainings
	 */
	public static List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end) {

		return getPersistence().findByByUserStatus(
			userId, courseStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().findByByUserStatus(
			userId, courseStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByByUserStatus(
			userId, courseStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByByUserStatus_First(
			long userId, String courseStatus,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByByUserStatus_First(
			userId, courseStatus, orderByComparator);
	}

	/**
	 * Returns the first training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByByUserStatus_First(
		long userId, String courseStatus,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByByUserStatus_First(
			userId, courseStatus, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByByUserStatus_Last(
			long userId, String courseStatus,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByByUserStatus_Last(
			userId, courseStatus, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByByUserStatus_Last(
		long userId, String courseStatus,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByByUserStatus_Last(
			userId, courseStatus, orderByComparator);
	}

	/**
	 * Returns the trainings before and after the current training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training[] findByByUserStatus_PrevAndNext(
			long trainingId, long userId, String courseStatus,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByByUserStatus_PrevAndNext(
			trainingId, userId, courseStatus, orderByComparator);
	}

	/**
	 * Removes all the trainings where userId = &#63; and courseStatus = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 */
	public static void removeByByUserStatus(long userId, String courseStatus) {
		getPersistence().removeByByUserStatus(userId, courseStatus);
	}

	/**
	 * Returns the number of trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @return the number of matching trainings
	 */
	public static int countByByUserStatus(long userId, String courseStatus) {
		return getPersistence().countByByUserStatus(userId, courseStatus);
	}

	/**
	 * Returns all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	public static List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation) {

		return getPersistence().findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation);
	}

	/**
	 * Returns a range of all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of matching trainings
	 */
	public static List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end) {

		return getPersistence().findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation, start, end);
	}

	/**
	 * Returns an ordered range of all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end, OrderByComparator<Training> orderByComparator) {

		return getPersistence().findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end, OrderByComparator<Training> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training in the ordered set where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByCourseNameCourseStatusOrganisation_First(
			String courseName, String courseStatus, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByCourseNameCourseStatusOrganisation_First(
			courseName, courseStatus, organisation, orderByComparator);
	}

	/**
	 * Returns the first training in the ordered set where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByCourseNameCourseStatusOrganisation_First(
		String courseName, String courseStatus, long organisation,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByCourseNameCourseStatusOrganisation_First(
			courseName, courseStatus, organisation, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByCourseNameCourseStatusOrganisation_Last(
			String courseName, String courseStatus, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByCourseNameCourseStatusOrganisation_Last(
			courseName, courseStatus, organisation, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByCourseNameCourseStatusOrganisation_Last(
		String courseName, String courseStatus, long organisation,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByCourseNameCourseStatusOrganisation_Last(
			courseName, courseStatus, organisation, orderByComparator);
	}

	/**
	 * Returns the trainings before and after the current training in the ordered set where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training[]
			findByCourseNameCourseStatusOrganisation_PrevAndNext(
				long trainingId, String courseName, String courseStatus,
				long organisation,
				OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().
			findByCourseNameCourseStatusOrganisation_PrevAndNext(
				trainingId, courseName, courseStatus, organisation,
				orderByComparator);
	}

	/**
	 * Removes all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63; from the database.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 */
	public static void removeByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation) {

		getPersistence().removeByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation);
	}

	/**
	 * Returns the number of trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	public static int countByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation) {

		return getPersistence().countByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation);
	}

	/**
	 * Returns all the trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	public static List<Training> findByCourseNameOrganisation(
		String courseName, long organisation) {

		return getPersistence().findByCourseNameOrganisation(
			courseName, organisation);
	}

	/**
	 * Returns a range of all the trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of matching trainings
	 */
	public static List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end) {

		return getPersistence().findByCourseNameOrganisation(
			courseName, organisation, start, end);
	}

	/**
	 * Returns an ordered range of all the trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().findByCourseNameOrganisation(
			courseName, organisation, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainings
	 */
	public static List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCourseNameOrganisation(
			courseName, organisation, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByCourseNameOrganisation_First(
			String courseName, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByCourseNameOrganisation_First(
			courseName, organisation, orderByComparator);
	}

	/**
	 * Returns the first training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByCourseNameOrganisation_First(
		String courseName, long organisation,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByCourseNameOrganisation_First(
			courseName, organisation, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public static Training findByCourseNameOrganisation_Last(
			String courseName, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByCourseNameOrganisation_Last(
			courseName, organisation, orderByComparator);
	}

	/**
	 * Returns the last training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchByCourseNameOrganisation_Last(
		String courseName, long organisation,
		OrderByComparator<Training> orderByComparator) {

		return getPersistence().fetchByCourseNameOrganisation_Last(
			courseName, organisation, orderByComparator);
	}

	/**
	 * Returns the trainings before and after the current training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training[] findByCourseNameOrganisation_PrevAndNext(
			long trainingId, String courseName, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByCourseNameOrganisation_PrevAndNext(
			trainingId, courseName, organisation, orderByComparator);
	}

	/**
	 * Removes all the trainings where courseName = &#63; and organisation = &#63; from the database.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 */
	public static void removeByCourseNameOrganisation(
		String courseName, long organisation) {

		getPersistence().removeByCourseNameOrganisation(
			courseName, organisation);
	}

	/**
	 * Returns the number of trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	public static int countByCourseNameOrganisation(
		String courseName, long organisation) {

		return getPersistence().countByCourseNameOrganisation(
			courseName, organisation);
	}

	/**
	 * Caches the training in the entity cache if it is enabled.
	 *
	 * @param training the training
	 */
	public static void cacheResult(Training training) {
		getPersistence().cacheResult(training);
	}

	/**
	 * Caches the trainings in the entity cache if it is enabled.
	 *
	 * @param trainings the trainings
	 */
	public static void cacheResult(List<Training> trainings) {
		getPersistence().cacheResult(trainings);
	}

	/**
	 * Creates a new training with the primary key. Does not add the training to the database.
	 *
	 * @param trainingId the primary key for the new training
	 * @return the new training
	 */
	public static Training create(long trainingId) {
		return getPersistence().create(trainingId);
	}

	/**
	 * Removes the training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training that was removed
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training remove(long trainingId)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().remove(trainingId);
	}

	public static Training updateImpl(Training training) {
		return getPersistence().updateImpl(training);
	}

	/**
	 * Returns the training with the primary key or throws a <code>NoSuchTrainingException</code> if it could not be found.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public static Training findByPrimaryKey(long trainingId)
		throws com.liferay.kris.thoughtmachine.exception.
			NoSuchTrainingException {

		return getPersistence().findByPrimaryKey(trainingId);
	}

	/**
	 * Returns the training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training, or <code>null</code> if a training with the primary key could not be found
	 */
	public static Training fetchByPrimaryKey(long trainingId) {
		return getPersistence().fetchByPrimaryKey(trainingId);
	}

	/**
	 * Returns all the trainings.
	 *
	 * @return the trainings
	 */
	public static List<Training> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of trainings
	 */
	public static List<Training> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainings
	 */
	public static List<Training> findAll(
		int start, int end, OrderByComparator<Training> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainings
	 */
	public static List<Training> findAll(
		int start, int end, OrderByComparator<Training> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trainings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trainings.
	 *
	 * @return the number of trainings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TrainingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TrainingPersistence, TrainingPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TrainingPersistence.class);

		ServiceTracker<TrainingPersistence, TrainingPersistence>
			serviceTracker =
				new ServiceTracker<TrainingPersistence, TrainingPersistence>(
					bundle.getBundleContext(), TrainingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
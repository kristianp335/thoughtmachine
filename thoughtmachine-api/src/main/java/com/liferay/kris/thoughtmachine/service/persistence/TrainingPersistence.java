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

import com.liferay.kris.thoughtmachine.exception.NoSuchTrainingException;
import com.liferay.kris.thoughtmachine.model.Training;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the training service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingUtil
 * @generated
 */
@ProviderType
public interface TrainingPersistence extends BasePersistence<Training> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrainingUtil} to access the training persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trainings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainings
	 */
	public java.util.List<Training> findByUuid(String uuid);

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
	public java.util.List<Training> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Training> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public java.util.List<Training> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the first training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the last training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the last training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the trainings before and after the current training in the ordered set where uuid = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public Training[] findByUuid_PrevAndNext(
			long trainingId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Removes all the trainings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trainings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainings
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTrainingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByUUID_G(String uuid, long groupId)
		throws NoSuchTrainingException;

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the training where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the training that was removed
	 */
	public Training removeByUUID_G(String uuid, long groupId)
		throws NoSuchTrainingException;

	/**
	 * Returns the number of trainings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainings
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainings
	 */
	public java.util.List<Training> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public java.util.List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the first training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the last training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the last training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public Training[] findByUuid_C_PrevAndNext(
			long trainingId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Removes all the trainings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainings
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the trainings where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	public java.util.List<Training> findByOrganisation(long organisation);

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
	public java.util.List<Training> findByOrganisation(
		long organisation, int start, int end);

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
	public java.util.List<Training> findByOrganisation(
		long organisation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public java.util.List<Training> findByOrganisation(
		long organisation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByOrganisation_First(
			long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the first training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByOrganisation_First(
		long organisation,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the last training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByOrganisation_Last(
			long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the last training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByOrganisation_Last(
		long organisation,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the trainings before and after the current training in the ordered set where organisation = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public Training[] findByOrganisation_PrevAndNext(
			long trainingId, long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Removes all the trainings where organisation = &#63; from the database.
	 *
	 * @param organisation the organisation
	 */
	public void removeByOrganisation(long organisation);

	/**
	 * Returns the number of trainings where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	public int countByOrganisation(long organisation);

	/**
	 * Returns all the trainings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching trainings
	 */
	public java.util.List<Training> findByByUser(long userId);

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
	public java.util.List<Training> findByByUser(
		long userId, int start, int end);

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
	public java.util.List<Training> findByByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public java.util.List<Training> findByByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByByUser_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the first training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the last training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByByUser_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the last training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the trainings before and after the current training in the ordered set where userId = &#63;.
	 *
	 * @param trainingId the primary key of the current training
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public Training[] findByByUser_PrevAndNext(
			long trainingId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Removes all the trainings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByByUser(long userId);

	/**
	 * Returns the number of trainings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching trainings
	 */
	public int countByByUser(long userId);

	/**
	 * Returns all the trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @return the matching trainings
	 */
	public java.util.List<Training> findByByUserStatus(
		long userId, String courseStatus);

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
	public java.util.List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end);

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
	public java.util.List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public java.util.List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByByUserStatus_First(
			long userId, String courseStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the first training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByByUserStatus_First(
		long userId, String courseStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the last training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByByUserStatus_Last(
			long userId, String courseStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the last training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByByUserStatus_Last(
		long userId, String courseStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public Training[] findByByUserStatus_PrevAndNext(
			long trainingId, long userId, String courseStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Removes all the trainings where userId = &#63; and courseStatus = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 */
	public void removeByByUserStatus(long userId, String courseStatus);

	/**
	 * Returns the number of trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @return the number of matching trainings
	 */
	public int countByByUserStatus(long userId, String courseStatus);

	/**
	 * Returns all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	public java.util.List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation);

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
	public java.util.List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end);

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
	public java.util.List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public java.util.List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator,
		boolean useFinderCache);

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
	public Training findByCourseNameCourseStatusOrganisation_First(
			String courseName, String courseStatus, long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the first training in the ordered set where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByCourseNameCourseStatusOrganisation_First(
		String courseName, String courseStatus, long organisation,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public Training findByCourseNameCourseStatusOrganisation_Last(
			String courseName, String courseStatus, long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the last training in the ordered set where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByCourseNameCourseStatusOrganisation_Last(
		String courseName, String courseStatus, long organisation,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public Training[] findByCourseNameCourseStatusOrganisation_PrevAndNext(
			long trainingId, String courseName, String courseStatus,
			long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Removes all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63; from the database.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 */
	public void removeByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation);

	/**
	 * Returns the number of trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	public int countByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation);

	/**
	 * Returns all the trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	public java.util.List<Training> findByCourseNameOrganisation(
		String courseName, long organisation);

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
	public java.util.List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end);

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
	public java.util.List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public java.util.List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByCourseNameOrganisation_First(
			String courseName, long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the first training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByCourseNameOrganisation_First(
		String courseName, long organisation,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

	/**
	 * Returns the last training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	public Training findByCourseNameOrganisation_Last(
			String courseName, long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Returns the last training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	public Training fetchByCourseNameOrganisation_Last(
		String courseName, long organisation,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public Training[] findByCourseNameOrganisation_PrevAndNext(
			long trainingId, String courseName, long organisation,
			com.liferay.portal.kernel.util.OrderByComparator<Training>
				orderByComparator)
		throws NoSuchTrainingException;

	/**
	 * Removes all the trainings where courseName = &#63; and organisation = &#63; from the database.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 */
	public void removeByCourseNameOrganisation(
		String courseName, long organisation);

	/**
	 * Returns the number of trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	public int countByCourseNameOrganisation(
		String courseName, long organisation);

	/**
	 * Caches the training in the entity cache if it is enabled.
	 *
	 * @param training the training
	 */
	public void cacheResult(Training training);

	/**
	 * Caches the trainings in the entity cache if it is enabled.
	 *
	 * @param trainings the trainings
	 */
	public void cacheResult(java.util.List<Training> trainings);

	/**
	 * Creates a new training with the primary key. Does not add the training to the database.
	 *
	 * @param trainingId the primary key for the new training
	 * @return the new training
	 */
	public Training create(long trainingId);

	/**
	 * Removes the training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training that was removed
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public Training remove(long trainingId) throws NoSuchTrainingException;

	public Training updateImpl(Training training);

	/**
	 * Returns the training with the primary key or throws a <code>NoSuchTrainingException</code> if it could not be found.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	public Training findByPrimaryKey(long trainingId)
		throws NoSuchTrainingException;

	/**
	 * Returns the training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training, or <code>null</code> if a training with the primary key could not be found
	 */
	public Training fetchByPrimaryKey(long trainingId);

	/**
	 * Returns all the trainings.
	 *
	 * @return the trainings
	 */
	public java.util.List<Training> findAll();

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
	public java.util.List<Training> findAll(int start, int end);

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
	public java.util.List<Training> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator);

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
	public java.util.List<Training> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Training>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trainings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trainings.
	 *
	 * @return the number of trainings
	 */
	public int countAll();

}
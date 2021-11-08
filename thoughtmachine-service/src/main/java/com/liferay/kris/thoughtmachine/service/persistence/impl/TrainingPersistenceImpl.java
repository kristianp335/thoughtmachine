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

package com.liferay.kris.thoughtmachine.service.persistence.impl;

import com.liferay.kris.thoughtmachine.exception.NoSuchTrainingException;
import com.liferay.kris.thoughtmachine.model.Training;
import com.liferay.kris.thoughtmachine.model.TrainingTable;
import com.liferay.kris.thoughtmachine.model.impl.TrainingImpl;
import com.liferay.kris.thoughtmachine.model.impl.TrainingModelImpl;
import com.liferay.kris.thoughtmachine.service.persistence.TrainingPersistence;
import com.liferay.kris.thoughtmachine.service.persistence.impl.constants.ThoughMachinePersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the training service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TrainingPersistence.class, BasePersistence.class})
public class TrainingPersistenceImpl
	extends BasePersistenceImpl<Training> implements TrainingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TrainingUtil</code> to access the training persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TrainingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the trainings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainings
	 */
	@Override
	public List<Training> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Training> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Training> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Training> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Training> list = null;

		if (useFinderCache) {
			list = (List<Training>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Training training : list) {
					if (!uuid.equals(training.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRAINING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Training>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	@Override
	public Training findByUuid_First(
			String uuid, OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByUuid_First(uuid, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the first training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByUuid_First(
		String uuid, OrderByComparator<Training> orderByComparator) {

		List<Training> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	@Override
	public Training findByUuid_Last(
			String uuid, OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByUuid_Last(uuid, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the last training in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByUuid_Last(
		String uuid, OrderByComparator<Training> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Training> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training[] findByUuid_PrevAndNext(
			long trainingId, String uuid,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		uuid = Objects.toString(uuid, "");

		Training training = findByPrimaryKey(trainingId);

		Session session = null;

		try {
			session = openSession();

			Training[] array = new TrainingImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, training, uuid, orderByComparator, true);

			array[1] = training;

			array[2] = getByUuid_PrevAndNext(
				session, training, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Training getByUuid_PrevAndNext(
		Session session, Training training, String uuid,
		OrderByComparator<Training> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAINING_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(training)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Training> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Training training :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(training);
		}
	}

	/**
	 * Returns the number of trainings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainings
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"training.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(training.uuid IS NULL OR training.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTrainingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	@Override
	public Training findByUUID_G(String uuid, long groupId)
		throws NoSuchTrainingException {

		Training training = fetchByUUID_G(uuid, groupId);

		if (training == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTrainingException(sb.toString());
		}

		return training;
	}

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the training where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof Training) {
			Training training = (Training)result;

			if (!Objects.equals(uuid, training.getUuid()) ||
				(groupId != training.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Training> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Training training = list.get(0);

					result = training;

					cacheResult(training);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Training)result;
		}
	}

	/**
	 * Removes the training where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the training that was removed
	 */
	@Override
	public Training removeByUUID_G(String uuid, long groupId)
		throws NoSuchTrainingException {

		Training training = findByUUID_G(uuid, groupId);

		return remove(training);
	}

	/**
	 * Returns the number of trainings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainings
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"training.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(training.uuid IS NULL OR training.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"training.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainings
	 */
	@Override
	public List<Training> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Training> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Training> list = null;

		if (useFinderCache) {
			list = (List<Training>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Training training : list) {
					if (!uuid.equals(training.getUuid()) ||
						(companyId != training.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRAINING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Training>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Training findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the first training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Training> orderByComparator) {

		List<Training> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the last training in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Training> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Training> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training[] findByUuid_C_PrevAndNext(
			long trainingId, String uuid, long companyId,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		uuid = Objects.toString(uuid, "");

		Training training = findByPrimaryKey(trainingId);

		Session session = null;

		try {
			session = openSession();

			Training[] array = new TrainingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, training, uuid, companyId, orderByComparator, true);

			array[1] = training;

			array[2] = getByUuid_C_PrevAndNext(
				session, training, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Training getByUuid_C_PrevAndNext(
		Session session, Training training, String uuid, long companyId,
		OrderByComparator<Training> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRAINING_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(training)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Training> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Training training :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(training);
		}
	}

	/**
	 * Returns the number of trainings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainings
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"training.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(training.uuid IS NULL OR training.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"training.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganisation;
	private FinderPath _finderPathWithoutPaginationFindByOrganisation;
	private FinderPath _finderPathCountByOrganisation;

	/**
	 * Returns all the trainings where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	@Override
	public List<Training> findByOrganisation(long organisation) {
		return findByOrganisation(
			organisation, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Training> findByOrganisation(
		long organisation, int start, int end) {

		return findByOrganisation(organisation, start, end, null);
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
	@Override
	public List<Training> findByOrganisation(
		long organisation, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return findByOrganisation(
			organisation, start, end, orderByComparator, true);
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
	@Override
	public List<Training> findByOrganisation(
		long organisation, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrganisation;
				finderArgs = new Object[] {organisation};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganisation;
			finderArgs = new Object[] {
				organisation, start, end, orderByComparator
			};
		}

		List<Training> list = null;

		if (useFinderCache) {
			list = (List<Training>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Training training : list) {
					if (organisation != training.getOrganisation()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRAINING_WHERE);

			sb.append(_FINDER_COLUMN_ORGANISATION_ORGANISATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organisation);

				list = (List<Training>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	@Override
	public Training findByOrganisation_First(
			long organisation, OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByOrganisation_First(
			organisation, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organisation=");
		sb.append(organisation);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the first training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByOrganisation_First(
		long organisation, OrderByComparator<Training> orderByComparator) {

		List<Training> list = findByOrganisation(
			organisation, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	@Override
	public Training findByOrganisation_Last(
			long organisation, OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByOrganisation_Last(
			organisation, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organisation=");
		sb.append(organisation);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the last training in the ordered set where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByOrganisation_Last(
		long organisation, OrderByComparator<Training> orderByComparator) {

		int count = countByOrganisation(organisation);

		if (count == 0) {
			return null;
		}

		List<Training> list = findByOrganisation(
			organisation, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training[] findByOrganisation_PrevAndNext(
			long trainingId, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = findByPrimaryKey(trainingId);

		Session session = null;

		try {
			session = openSession();

			Training[] array = new TrainingImpl[3];

			array[0] = getByOrganisation_PrevAndNext(
				session, training, organisation, orderByComparator, true);

			array[1] = training;

			array[2] = getByOrganisation_PrevAndNext(
				session, training, organisation, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Training getByOrganisation_PrevAndNext(
		Session session, Training training, long organisation,
		OrderByComparator<Training> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAINING_WHERE);

		sb.append(_FINDER_COLUMN_ORGANISATION_ORGANISATION_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(organisation);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(training)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Training> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainings where organisation = &#63; from the database.
	 *
	 * @param organisation the organisation
	 */
	@Override
	public void removeByOrganisation(long organisation) {
		for (Training training :
				findByOrganisation(
					organisation, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(training);
		}
	}

	/**
	 * Returns the number of trainings where organisation = &#63;.
	 *
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	@Override
	public int countByOrganisation(long organisation) {
		FinderPath finderPath = _finderPathCountByOrganisation;

		Object[] finderArgs = new Object[] {organisation};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINING_WHERE);

			sb.append(_FINDER_COLUMN_ORGANISATION_ORGANISATION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organisation);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANISATION_ORGANISATION_2 =
		"training.organisation = ?";

	private FinderPath _finderPathWithPaginationFindByByUser;
	private FinderPath _finderPathWithoutPaginationFindByByUser;
	private FinderPath _finderPathCountByByUser;

	/**
	 * Returns all the trainings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching trainings
	 */
	@Override
	public List<Training> findByByUser(long userId) {
		return findByByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Training> findByByUser(long userId, int start, int end) {
		return findByByUser(userId, start, end, null);
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
	@Override
	public List<Training> findByByUser(
		long userId, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return findByByUser(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Training> findByByUser(
		long userId, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByByUser;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByByUser;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Training> list = null;

		if (useFinderCache) {
			list = (List<Training>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Training training : list) {
					if (userId != training.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRAINING_WHERE);

			sb.append(_FINDER_COLUMN_BYUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Training>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	@Override
	public Training findByByUser_First(
			long userId, OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByByUser_First(userId, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the first training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByByUser_First(
		long userId, OrderByComparator<Training> orderByComparator) {

		List<Training> list = findByByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training
	 * @throws NoSuchTrainingException if a matching training could not be found
	 */
	@Override
	public Training findByByUser_Last(
			long userId, OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByByUser_Last(userId, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the last training in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByByUser_Last(
		long userId, OrderByComparator<Training> orderByComparator) {

		int count = countByByUser(userId);

		if (count == 0) {
			return null;
		}

		List<Training> list = findByByUser(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training[] findByByUser_PrevAndNext(
			long trainingId, long userId,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = findByPrimaryKey(trainingId);

		Session session = null;

		try {
			session = openSession();

			Training[] array = new TrainingImpl[3];

			array[0] = getByByUser_PrevAndNext(
				session, training, userId, orderByComparator, true);

			array[1] = training;

			array[2] = getByByUser_PrevAndNext(
				session, training, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Training getByByUser_PrevAndNext(
		Session session, Training training, long userId,
		OrderByComparator<Training> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAINING_WHERE);

		sb.append(_FINDER_COLUMN_BYUSER_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(training)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Training> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByByUser(long userId) {
		for (Training training :
				findByByUser(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(training);
		}
	}

	/**
	 * Returns the number of trainings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching trainings
	 */
	@Override
	public int countByByUser(long userId) {
		FinderPath finderPath = _finderPathCountByByUser;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINING_WHERE);

			sb.append(_FINDER_COLUMN_BYUSER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYUSER_USERID_2 =
		"training.userId = ?";

	private FinderPath _finderPathWithPaginationFindByByUserStatus;
	private FinderPath _finderPathWithoutPaginationFindByByUserStatus;
	private FinderPath _finderPathCountByByUserStatus;

	/**
	 * Returns all the trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @return the matching trainings
	 */
	@Override
	public List<Training> findByByUserStatus(long userId, String courseStatus) {
		return findByByUserStatus(
			userId, courseStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end) {

		return findByByUserStatus(userId, courseStatus, start, end, null);
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
	@Override
	public List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return findByByUserStatus(
			userId, courseStatus, start, end, orderByComparator, true);
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
	@Override
	public List<Training> findByByUserStatus(
		long userId, String courseStatus, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		courseStatus = Objects.toString(courseStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByByUserStatus;
				finderArgs = new Object[] {userId, courseStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByByUserStatus;
			finderArgs = new Object[] {
				userId, courseStatus, start, end, orderByComparator
			};
		}

		List<Training> list = null;

		if (useFinderCache) {
			list = (List<Training>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Training training : list) {
					if ((userId != training.getUserId()) ||
						!courseStatus.equals(training.getCourseStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRAINING_WHERE);

			sb.append(_FINDER_COLUMN_BYUSERSTATUS_USERID_2);

			boolean bindCourseStatus = false;

			if (courseStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYUSERSTATUS_COURSESTATUS_3);
			}
			else {
				bindCourseStatus = true;

				sb.append(_FINDER_COLUMN_BYUSERSTATUS_COURSESTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindCourseStatus) {
					queryPos.add(courseStatus);
				}

				list = (List<Training>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Training findByByUserStatus_First(
			long userId, String courseStatus,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByByUserStatus_First(
			userId, courseStatus, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", courseStatus=");
		sb.append(courseStatus);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the first training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByByUserStatus_First(
		long userId, String courseStatus,
		OrderByComparator<Training> orderByComparator) {

		List<Training> list = findByByUserStatus(
			userId, courseStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training findByByUserStatus_Last(
			long userId, String courseStatus,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByByUserStatus_Last(
			userId, courseStatus, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", courseStatus=");
		sb.append(courseStatus);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the last training in the ordered set where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByByUserStatus_Last(
		long userId, String courseStatus,
		OrderByComparator<Training> orderByComparator) {

		int count = countByByUserStatus(userId, courseStatus);

		if (count == 0) {
			return null;
		}

		List<Training> list = findByByUserStatus(
			userId, courseStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training[] findByByUserStatus_PrevAndNext(
			long trainingId, long userId, String courseStatus,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		courseStatus = Objects.toString(courseStatus, "");

		Training training = findByPrimaryKey(trainingId);

		Session session = null;

		try {
			session = openSession();

			Training[] array = new TrainingImpl[3];

			array[0] = getByByUserStatus_PrevAndNext(
				session, training, userId, courseStatus, orderByComparator,
				true);

			array[1] = training;

			array[2] = getByByUserStatus_PrevAndNext(
				session, training, userId, courseStatus, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Training getByByUserStatus_PrevAndNext(
		Session session, Training training, long userId, String courseStatus,
		OrderByComparator<Training> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRAINING_WHERE);

		sb.append(_FINDER_COLUMN_BYUSERSTATUS_USERID_2);

		boolean bindCourseStatus = false;

		if (courseStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_BYUSERSTATUS_COURSESTATUS_3);
		}
		else {
			bindCourseStatus = true;

			sb.append(_FINDER_COLUMN_BYUSERSTATUS_COURSESTATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindCourseStatus) {
			queryPos.add(courseStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(training)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Training> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainings where userId = &#63; and courseStatus = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 */
	@Override
	public void removeByByUserStatus(long userId, String courseStatus) {
		for (Training training :
				findByByUserStatus(
					userId, courseStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(training);
		}
	}

	/**
	 * Returns the number of trainings where userId = &#63; and courseStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param courseStatus the course status
	 * @return the number of matching trainings
	 */
	@Override
	public int countByByUserStatus(long userId, String courseStatus) {
		courseStatus = Objects.toString(courseStatus, "");

		FinderPath finderPath = _finderPathCountByByUserStatus;

		Object[] finderArgs = new Object[] {userId, courseStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINING_WHERE);

			sb.append(_FINDER_COLUMN_BYUSERSTATUS_USERID_2);

			boolean bindCourseStatus = false;

			if (courseStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYUSERSTATUS_COURSESTATUS_3);
			}
			else {
				bindCourseStatus = true;

				sb.append(_FINDER_COLUMN_BYUSERSTATUS_COURSESTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindCourseStatus) {
					queryPos.add(courseStatus);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYUSERSTATUS_USERID_2 =
		"training.userId = ? AND ";

	private static final String _FINDER_COLUMN_BYUSERSTATUS_COURSESTATUS_2 =
		"training.courseStatus = ?";

	private static final String _FINDER_COLUMN_BYUSERSTATUS_COURSESTATUS_3 =
		"(training.courseStatus IS NULL OR training.courseStatus = '')";

	private FinderPath
		_finderPathWithPaginationFindByCourseNameCourseStatusOrganisation;
	private FinderPath
		_finderPathWithoutPaginationFindByCourseNameCourseStatusOrganisation;
	private FinderPath _finderPathCountByCourseNameCourseStatusOrganisation;

	/**
	 * Returns all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	@Override
	public List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation) {

		return findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end) {

		return findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation, start, end, null);
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
	@Override
	public List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end, OrderByComparator<Training> orderByComparator) {

		return findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation, start, end,
			orderByComparator, true);
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
	@Override
	public List<Training> findByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation, int start,
		int end, OrderByComparator<Training> orderByComparator,
		boolean useFinderCache) {

		courseName = Objects.toString(courseName, "");
		courseStatus = Objects.toString(courseStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCourseNameCourseStatusOrganisation;
				finderArgs = new Object[] {
					courseName, courseStatus, organisation
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByCourseNameCourseStatusOrganisation;
			finderArgs = new Object[] {
				courseName, courseStatus, organisation, start, end,
				orderByComparator
			};
		}

		List<Training> list = null;

		if (useFinderCache) {
			list = (List<Training>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Training training : list) {
					if (!courseName.equals(training.getCourseName()) ||
						!courseStatus.equals(training.getCourseStatus()) ||
						(organisation != training.getOrganisation())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_TRAINING_WHERE);

			boolean bindCourseName = false;

			if (courseName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSENAME_3);
			}
			else {
				bindCourseName = true;

				sb.append(
					_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSENAME_2);
			}

			boolean bindCourseStatus = false;

			if (courseStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSESTATUS_3);
			}
			else {
				bindCourseStatus = true;

				sb.append(
					_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSESTATUS_2);
			}

			sb.append(
				_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_ORGANISATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCourseName) {
					queryPos.add(courseName);
				}

				if (bindCourseStatus) {
					queryPos.add(courseStatus);
				}

				queryPos.add(organisation);

				list = (List<Training>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Training findByCourseNameCourseStatusOrganisation_First(
			String courseName, String courseStatus, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByCourseNameCourseStatusOrganisation_First(
			courseName, courseStatus, organisation, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("courseName=");
		sb.append(courseName);

		sb.append(", courseStatus=");
		sb.append(courseStatus);

		sb.append(", organisation=");
		sb.append(organisation);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
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
	@Override
	public Training fetchByCourseNameCourseStatusOrganisation_First(
		String courseName, String courseStatus, long organisation,
		OrderByComparator<Training> orderByComparator) {

		List<Training> list = findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training findByCourseNameCourseStatusOrganisation_Last(
			String courseName, String courseStatus, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByCourseNameCourseStatusOrganisation_Last(
			courseName, courseStatus, organisation, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("courseName=");
		sb.append(courseName);

		sb.append(", courseStatus=");
		sb.append(courseStatus);

		sb.append(", organisation=");
		sb.append(organisation);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
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
	@Override
	public Training fetchByCourseNameCourseStatusOrganisation_Last(
		String courseName, String courseStatus, long organisation,
		OrderByComparator<Training> orderByComparator) {

		int count = countByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation);

		if (count == 0) {
			return null;
		}

		List<Training> list = findByCourseNameCourseStatusOrganisation(
			courseName, courseStatus, organisation, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training[] findByCourseNameCourseStatusOrganisation_PrevAndNext(
			long trainingId, String courseName, String courseStatus,
			long organisation, OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		courseName = Objects.toString(courseName, "");
		courseStatus = Objects.toString(courseStatus, "");

		Training training = findByPrimaryKey(trainingId);

		Session session = null;

		try {
			session = openSession();

			Training[] array = new TrainingImpl[3];

			array[0] = getByCourseNameCourseStatusOrganisation_PrevAndNext(
				session, training, courseName, courseStatus, organisation,
				orderByComparator, true);

			array[1] = training;

			array[2] = getByCourseNameCourseStatusOrganisation_PrevAndNext(
				session, training, courseName, courseStatus, organisation,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Training getByCourseNameCourseStatusOrganisation_PrevAndNext(
		Session session, Training training, String courseName,
		String courseStatus, long organisation,
		OrderByComparator<Training> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_TRAINING_WHERE);

		boolean bindCourseName = false;

		if (courseName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSENAME_3);
		}
		else {
			bindCourseName = true;

			sb.append(
				_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSENAME_2);
		}

		boolean bindCourseStatus = false;

		if (courseStatus.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSESTATUS_3);
		}
		else {
			bindCourseStatus = true;

			sb.append(
				_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSESTATUS_2);
		}

		sb.append(
			_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_ORGANISATION_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCourseName) {
			queryPos.add(courseName);
		}

		if (bindCourseStatus) {
			queryPos.add(courseStatus);
		}

		queryPos.add(organisation);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(training)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Training> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63; from the database.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 */
	@Override
	public void removeByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation) {

		for (Training training :
				findByCourseNameCourseStatusOrganisation(
					courseName, courseStatus, organisation, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(training);
		}
	}

	/**
	 * Returns the number of trainings where courseName = &#63; and courseStatus = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param courseStatus the course status
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	@Override
	public int countByCourseNameCourseStatusOrganisation(
		String courseName, String courseStatus, long organisation) {

		courseName = Objects.toString(courseName, "");
		courseStatus = Objects.toString(courseStatus, "");

		FinderPath finderPath =
			_finderPathCountByCourseNameCourseStatusOrganisation;

		Object[] finderArgs = new Object[] {
			courseName, courseStatus, organisation
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TRAINING_WHERE);

			boolean bindCourseName = false;

			if (courseName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSENAME_3);
			}
			else {
				bindCourseName = true;

				sb.append(
					_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSENAME_2);
			}

			boolean bindCourseStatus = false;

			if (courseStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSESTATUS_3);
			}
			else {
				bindCourseStatus = true;

				sb.append(
					_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSESTATUS_2);
			}

			sb.append(
				_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_ORGANISATION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCourseName) {
					queryPos.add(courseName);
				}

				if (bindCourseStatus) {
					queryPos.add(courseStatus);
				}

				queryPos.add(organisation);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSENAME_2 =
			"training.courseName = ? AND ";

	private static final String
		_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSENAME_3 =
			"(training.courseName IS NULL OR training.courseName = '') AND ";

	private static final String
		_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSESTATUS_2 =
			"training.courseStatus = ? AND ";

	private static final String
		_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_COURSESTATUS_3 =
			"(training.courseStatus IS NULL OR training.courseStatus = '') AND ";

	private static final String
		_FINDER_COLUMN_COURSENAMECOURSESTATUSORGANISATION_ORGANISATION_2 =
			"training.organisation = ?";

	private FinderPath _finderPathWithPaginationFindByCourseNameOrganisation;
	private FinderPath _finderPathWithoutPaginationFindByCourseNameOrganisation;
	private FinderPath _finderPathCountByCourseNameOrganisation;

	/**
	 * Returns all the trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @return the matching trainings
	 */
	@Override
	public List<Training> findByCourseNameOrganisation(
		String courseName, long organisation) {

		return findByCourseNameOrganisation(
			courseName, organisation, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end) {

		return findByCourseNameOrganisation(
			courseName, organisation, start, end, null);
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
	@Override
	public List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return findByCourseNameOrganisation(
			courseName, organisation, start, end, orderByComparator, true);
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
	@Override
	public List<Training> findByCourseNameOrganisation(
		String courseName, long organisation, int start, int end,
		OrderByComparator<Training> orderByComparator, boolean useFinderCache) {

		courseName = Objects.toString(courseName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCourseNameOrganisation;
				finderArgs = new Object[] {courseName, organisation};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCourseNameOrganisation;
			finderArgs = new Object[] {
				courseName, organisation, start, end, orderByComparator
			};
		}

		List<Training> list = null;

		if (useFinderCache) {
			list = (List<Training>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Training training : list) {
					if (!courseName.equals(training.getCourseName()) ||
						(organisation != training.getOrganisation())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRAINING_WHERE);

			boolean bindCourseName = false;

			if (courseName.isEmpty()) {
				sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_COURSENAME_3);
			}
			else {
				bindCourseName = true;

				sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_COURSENAME_2);
			}

			sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_ORGANISATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCourseName) {
					queryPos.add(courseName);
				}

				queryPos.add(organisation);

				list = (List<Training>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Training findByCourseNameOrganisation_First(
			String courseName, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByCourseNameOrganisation_First(
			courseName, organisation, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("courseName=");
		sb.append(courseName);

		sb.append(", organisation=");
		sb.append(organisation);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the first training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByCourseNameOrganisation_First(
		String courseName, long organisation,
		OrderByComparator<Training> orderByComparator) {

		List<Training> list = findByCourseNameOrganisation(
			courseName, organisation, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training findByCourseNameOrganisation_Last(
			String courseName, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		Training training = fetchByCourseNameOrganisation_Last(
			courseName, organisation, orderByComparator);

		if (training != null) {
			return training;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("courseName=");
		sb.append(courseName);

		sb.append(", organisation=");
		sb.append(organisation);

		sb.append("}");

		throw new NoSuchTrainingException(sb.toString());
	}

	/**
	 * Returns the last training in the ordered set where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public Training fetchByCourseNameOrganisation_Last(
		String courseName, long organisation,
		OrderByComparator<Training> orderByComparator) {

		int count = countByCourseNameOrganisation(courseName, organisation);

		if (count == 0) {
			return null;
		}

		List<Training> list = findByCourseNameOrganisation(
			courseName, organisation, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Training[] findByCourseNameOrganisation_PrevAndNext(
			long trainingId, String courseName, long organisation,
			OrderByComparator<Training> orderByComparator)
		throws NoSuchTrainingException {

		courseName = Objects.toString(courseName, "");

		Training training = findByPrimaryKey(trainingId);

		Session session = null;

		try {
			session = openSession();

			Training[] array = new TrainingImpl[3];

			array[0] = getByCourseNameOrganisation_PrevAndNext(
				session, training, courseName, organisation, orderByComparator,
				true);

			array[1] = training;

			array[2] = getByCourseNameOrganisation_PrevAndNext(
				session, training, courseName, organisation, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Training getByCourseNameOrganisation_PrevAndNext(
		Session session, Training training, String courseName,
		long organisation, OrderByComparator<Training> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRAINING_WHERE);

		boolean bindCourseName = false;

		if (courseName.isEmpty()) {
			sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_COURSENAME_3);
		}
		else {
			bindCourseName = true;

			sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_COURSENAME_2);
		}

		sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_ORGANISATION_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCourseName) {
			queryPos.add(courseName);
		}

		queryPos.add(organisation);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(training)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Training> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainings where courseName = &#63; and organisation = &#63; from the database.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 */
	@Override
	public void removeByCourseNameOrganisation(
		String courseName, long organisation) {

		for (Training training :
				findByCourseNameOrganisation(
					courseName, organisation, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(training);
		}
	}

	/**
	 * Returns the number of trainings where courseName = &#63; and organisation = &#63;.
	 *
	 * @param courseName the course name
	 * @param organisation the organisation
	 * @return the number of matching trainings
	 */
	@Override
	public int countByCourseNameOrganisation(
		String courseName, long organisation) {

		courseName = Objects.toString(courseName, "");

		FinderPath finderPath = _finderPathCountByCourseNameOrganisation;

		Object[] finderArgs = new Object[] {courseName, organisation};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINING_WHERE);

			boolean bindCourseName = false;

			if (courseName.isEmpty()) {
				sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_COURSENAME_3);
			}
			else {
				bindCourseName = true;

				sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_COURSENAME_2);
			}

			sb.append(_FINDER_COLUMN_COURSENAMEORGANISATION_ORGANISATION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCourseName) {
					queryPos.add(courseName);
				}

				queryPos.add(organisation);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COURSENAMEORGANISATION_COURSENAME_2 =
			"training.courseName = ? AND ";

	private static final String
		_FINDER_COLUMN_COURSENAMEORGANISATION_COURSENAME_3 =
			"(training.courseName IS NULL OR training.courseName = '') AND ";

	private static final String
		_FINDER_COLUMN_COURSENAMEORGANISATION_ORGANISATION_2 =
			"training.organisation = ?";

	public TrainingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Training.class);

		setModelImplClass(TrainingImpl.class);
		setModelPKClass(long.class);

		setTable(TrainingTable.INSTANCE);
	}

	/**
	 * Caches the training in the entity cache if it is enabled.
	 *
	 * @param training the training
	 */
	@Override
	public void cacheResult(Training training) {
		entityCache.putResult(
			TrainingImpl.class, training.getPrimaryKey(), training);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {training.getUuid(), training.getGroupId()}, training);
	}

	/**
	 * Caches the trainings in the entity cache if it is enabled.
	 *
	 * @param trainings the trainings
	 */
	@Override
	public void cacheResult(List<Training> trainings) {
		for (Training training : trainings) {
			if (entityCache.getResult(
					TrainingImpl.class, training.getPrimaryKey()) == null) {

				cacheResult(training);
			}
		}
	}

	/**
	 * Clears the cache for all trainings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TrainingImpl.class);

		finderCache.clearCache(TrainingImpl.class);
	}

	/**
	 * Clears the cache for the training.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Training training) {
		entityCache.removeResult(TrainingImpl.class, training);
	}

	@Override
	public void clearCache(List<Training> trainings) {
		for (Training training : trainings) {
			entityCache.removeResult(TrainingImpl.class, training);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TrainingImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TrainingImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TrainingModelImpl trainingModelImpl) {

		Object[] args = new Object[] {
			trainingModelImpl.getUuid(), trainingModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, trainingModelImpl);
	}

	/**
	 * Creates a new training with the primary key. Does not add the training to the database.
	 *
	 * @param trainingId the primary key for the new training
	 * @return the new training
	 */
	@Override
	public Training create(long trainingId) {
		Training training = new TrainingImpl();

		training.setNew(true);
		training.setPrimaryKey(trainingId);

		String uuid = PortalUUIDUtil.generate();

		training.setUuid(uuid);

		training.setCompanyId(CompanyThreadLocal.getCompanyId());

		return training;
	}

	/**
	 * Removes the training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training that was removed
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	@Override
	public Training remove(long trainingId) throws NoSuchTrainingException {
		return remove((Serializable)trainingId);
	}

	/**
	 * Removes the training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the training
	 * @return the training that was removed
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	@Override
	public Training remove(Serializable primaryKey)
		throws NoSuchTrainingException {

		Session session = null;

		try {
			session = openSession();

			Training training = (Training)session.get(
				TrainingImpl.class, primaryKey);

			if (training == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrainingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(training);
		}
		catch (NoSuchTrainingException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Training removeImpl(Training training) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(training)) {
				training = (Training)session.get(
					TrainingImpl.class, training.getPrimaryKeyObj());
			}

			if (training != null) {
				session.delete(training);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (training != null) {
			clearCache(training);
		}

		return training;
	}

	@Override
	public Training updateImpl(Training training) {
		boolean isNew = training.isNew();

		if (!(training instanceof TrainingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(training.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(training);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in training proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Training implementation " +
					training.getClass());
		}

		TrainingModelImpl trainingModelImpl = (TrainingModelImpl)training;

		if (Validator.isNull(training.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			training.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (training.getCreateDate() == null)) {
			if (serviceContext == null) {
				training.setCreateDate(date);
			}
			else {
				training.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!trainingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				training.setModifiedDate(date);
			}
			else {
				training.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(training);
			}
			else {
				training = (Training)session.merge(training);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TrainingImpl.class, trainingModelImpl, false, true);

		cacheUniqueFindersCache(trainingModelImpl);

		if (isNew) {
			training.setNew(false);
		}

		training.resetOriginalValues();

		return training;
	}

	/**
	 * Returns the training with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the training
	 * @return the training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	@Override
	public Training findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrainingException {

		Training training = fetchByPrimaryKey(primaryKey);

		if (training == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTrainingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return training;
	}

	/**
	 * Returns the training with the primary key or throws a <code>NoSuchTrainingException</code> if it could not be found.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training
	 * @throws NoSuchTrainingException if a training with the primary key could not be found
	 */
	@Override
	public Training findByPrimaryKey(long trainingId)
		throws NoSuchTrainingException {

		return findByPrimaryKey((Serializable)trainingId);
	}

	/**
	 * Returns the training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training, or <code>null</code> if a training with the primary key could not be found
	 */
	@Override
	public Training fetchByPrimaryKey(long trainingId) {
		return fetchByPrimaryKey((Serializable)trainingId);
	}

	/**
	 * Returns all the trainings.
	 *
	 * @return the trainings
	 */
	@Override
	public List<Training> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Training> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Training> findAll(
		int start, int end, OrderByComparator<Training> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Training> findAll(
		int start, int end, OrderByComparator<Training> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Training> list = null;

		if (useFinderCache) {
			list = (List<Training>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINING;

				sql = sql.concat(TrainingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Training>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the trainings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Training training : findAll()) {
			remove(training);
		}
	}

	/**
	 * Returns the number of trainings.
	 *
	 * @return the number of trainings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TRAINING);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "trainingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TrainingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the training persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new TrainingModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByOrganisation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganisation",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"organisation"}, true);

		_finderPathWithoutPaginationFindByOrganisation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganisation",
			new String[] {Long.class.getName()}, new String[] {"organisation"},
			true);

		_finderPathCountByOrganisation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganisation",
			new String[] {Long.class.getName()}, new String[] {"organisation"},
			false);

		_finderPathWithPaginationFindByByUser = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByByUser = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByUser",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByByUser = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByUser",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByByUserStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByUserStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "courseStatus"}, true);

		_finderPathWithoutPaginationFindByByUserStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByUserStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "courseStatus"}, true);

		_finderPathCountByByUserStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByUserStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "courseStatus"}, false);

		_finderPathWithPaginationFindByCourseNameCourseStatusOrganisation =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCourseNameCourseStatusOrganisation",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"courseName", "courseStatus", "organisation"},
				true);

		_finderPathWithoutPaginationFindByCourseNameCourseStatusOrganisation =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCourseNameCourseStatusOrganisation",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				new String[] {"courseName", "courseStatus", "organisation"},
				true);

		_finderPathCountByCourseNameCourseStatusOrganisation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseNameCourseStatusOrganisation",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"courseName", "courseStatus", "organisation"}, false);

		_finderPathWithPaginationFindByCourseNameOrganisation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseNameOrganisation",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"courseName", "organisation"}, true);

		_finderPathWithoutPaginationFindByCourseNameOrganisation =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCourseNameOrganisation",
				new String[] {String.class.getName(), Long.class.getName()},
				new String[] {"courseName", "organisation"}, true);

		_finderPathCountByCourseNameOrganisation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseNameOrganisation",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"courseName", "organisation"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TrainingImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = ThoughMachinePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ThoughMachinePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ThoughMachinePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TRAINING =
		"SELECT training FROM Training training";

	private static final String _SQL_SELECT_TRAINING_WHERE =
		"SELECT training FROM Training training WHERE ";

	private static final String _SQL_COUNT_TRAINING =
		"SELECT COUNT(training) FROM Training training";

	private static final String _SQL_COUNT_TRAINING_WHERE =
		"SELECT COUNT(training) FROM Training training WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "training.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Training exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Training exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TrainingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class TrainingModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			TrainingModelImpl trainingModelImpl = (TrainingModelImpl)baseModel;

			long columnBitmask = trainingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(trainingModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						trainingModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(trainingModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return TrainingImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return TrainingTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			TrainingModelImpl trainingModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = trainingModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = trainingModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= TrainingModelImpl.getColumnBitmask(
				"courseName");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}
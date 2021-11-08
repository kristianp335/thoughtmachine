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

package com.liferay.kris.thoughtmachine.service;

import com.liferay.kris.thoughtmachine.model.Training;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Training. This utility wraps
 * <code>com.liferay.kris.thoughtmachine.service.impl.TrainingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingLocalService
 * @generated
 */
public class TrainingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.kris.thoughtmachine.service.impl.TrainingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the training to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param training the training
	 * @return the training that was added
	 */
	public static Training addTraining(Training training) {
		return getService().addTraining(training);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new training with the primary key. Does not add the training to the database.
	 *
	 * @param trainingId the primary key for the new training
	 * @return the new training
	 */
	public static Training createTraining(long trainingId) {
		return getService().createTraining(trainingId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingId the primary key of the training
	 * @return the training that was removed
	 * @throws PortalException if a training with the primary key could not be found
	 */
	public static Training deleteTraining(long trainingId)
		throws PortalException {

		return getService().deleteTraining(trainingId);
	}

	/**
	 * Deletes the training from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param training the training
	 * @return the training that was removed
	 */
	public static Training deleteTraining(Training training) {
		return getService().deleteTraining(training);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.kris.thoughtmachine.model.impl.TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.kris.thoughtmachine.model.impl.TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Training fetchTraining(long trainingId) {
		return getService().fetchTraining(trainingId);
	}

	/**
	 * Returns the training matching the UUID and group.
	 *
	 * @param uuid the training's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training, or <code>null</code> if a matching training could not be found
	 */
	public static Training fetchTrainingByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTrainingByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static int[] getCompleted(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getCompleted(serviceContext);
	}

	public static int[] getCompletedByCourseAndOrganisation(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		String courseNameSelected) {

		return getService().getCompletedByCourseAndOrganisation(
			serviceContext, courseNameSelected);
	}

	public static List<Training> getCompletedByCourseAndOrganisationList(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		String courseNameSelected) {

		return getService().getCompletedByCourseAndOrganisationList(
			serviceContext, courseNameSelected);
	}

	public static List
		<com.liferay.kris.thoughtmachine.model.TrainingCompletedUser>
			getCompletedByOrganisationList(
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return getService().getCompletedByOrganisationList(serviceContext);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the training with the primary key.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training
	 * @throws PortalException if a training with the primary key could not be found
	 */
	public static Training getTraining(long trainingId) throws PortalException {
		return getService().getTraining(trainingId);
	}

	public static List<Training> getTraining(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getTraining(serviceContext);
	}

	public static List<Training> getTrainingByOrganisation(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getTrainingByOrganisation(serviceContext);
	}

	/**
	 * Returns the training matching the UUID and group.
	 *
	 * @param uuid the training's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training
	 * @throws PortalException if a matching training could not be found
	 */
	public static Training getTrainingByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTrainingByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.kris.thoughtmachine.model.impl.TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of trainings
	 */
	public static List<Training> getTrainings(int start, int end) {
		return getService().getTrainings(start, end);
	}

	/**
	 * Returns all the trainings matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainings
	 * @param companyId the primary key of the company
	 * @return the matching trainings, or an empty list if no matches were found
	 */
	public static List<Training> getTrainingsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTrainingsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of trainings matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainings, or an empty list if no matches were found
	 */
	public static List<Training> getTrainingsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Training> orderByComparator) {

		return getService().getTrainingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainings.
	 *
	 * @return the number of trainings
	 */
	public static int getTrainingsCount() {
		return getService().getTrainingsCount();
	}

	/**
	 * Updates the training in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param training the training
	 * @return the training that was updated
	 */
	public static Training updateTraining(Training training) {
		return getService().updateTraining(training);
	}

	public static TrainingLocalService getService() {
		return _service;
	}

	private static volatile TrainingLocalService _service;

}
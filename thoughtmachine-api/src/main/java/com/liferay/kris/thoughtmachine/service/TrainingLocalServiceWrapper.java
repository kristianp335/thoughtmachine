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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrainingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingLocalService
 * @generated
 */
public class TrainingLocalServiceWrapper
	implements ServiceWrapper<TrainingLocalService>, TrainingLocalService {

	public TrainingLocalServiceWrapper(
		TrainingLocalService trainingLocalService) {

		_trainingLocalService = trainingLocalService;
	}

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
	@Override
	public com.liferay.kris.thoughtmachine.model.Training addTraining(
		com.liferay.kris.thoughtmachine.model.Training training) {

		return _trainingLocalService.addTraining(training);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new training with the primary key. Does not add the training to the database.
	 *
	 * @param trainingId the primary key for the new training
	 * @return the new training
	 */
	@Override
	public com.liferay.kris.thoughtmachine.model.Training createTraining(
		long trainingId) {

		return _trainingLocalService.createTraining(trainingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.liferay.kris.thoughtmachine.model.Training deleteTraining(
			long trainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.deleteTraining(trainingId);
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
	@Override
	public com.liferay.kris.thoughtmachine.model.Training deleteTraining(
		com.liferay.kris.thoughtmachine.model.Training training) {

		return _trainingLocalService.deleteTraining(training);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _trainingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _trainingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trainingLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _trainingLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _trainingLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _trainingLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _trainingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _trainingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.kris.thoughtmachine.model.Training fetchTraining(
		long trainingId) {

		return _trainingLocalService.fetchTraining(trainingId);
	}

	/**
	 * Returns the training matching the UUID and group.
	 *
	 * @param uuid the training's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training, or <code>null</code> if a matching training could not be found
	 */
	@Override
	public com.liferay.kris.thoughtmachine.model.Training
		fetchTrainingByUuidAndGroupId(String uuid, long groupId) {

		return _trainingLocalService.fetchTrainingByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _trainingLocalService.getActionableDynamicQuery();
	}

	@Override
	public int[] getCompleted(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _trainingLocalService.getCompleted(serviceContext);
	}

	@Override
	public int[] getCompletedByCourseAndOrganisation(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		String courseNameSelected) {

		return _trainingLocalService.getCompletedByCourseAndOrganisation(
			serviceContext, courseNameSelected);
	}

	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getCompletedByCourseAndOrganisationList(
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String courseNameSelected) {

		return _trainingLocalService.getCompletedByCourseAndOrganisationList(
			serviceContext, courseNameSelected);
	}

	@Override
	public java.util.List
		<com.liferay.kris.thoughtmachine.model.TrainingCompletedUser>
			getCompletedByOrganisationList(
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _trainingLocalService.getCompletedByOrganisationList(
			serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _trainingLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _trainingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trainingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the training with the primary key.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training
	 * @throws PortalException if a training with the primary key could not be found
	 */
	@Override
	public com.liferay.kris.thoughtmachine.model.Training getTraining(
			long trainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.getTraining(trainingId);
	}

	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTraining(
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _trainingLocalService.getTraining(serviceContext);
	}

	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTrainingByOrganisation(
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _trainingLocalService.getTrainingByOrganisation(serviceContext);
	}

	/**
	 * Returns the training matching the UUID and group.
	 *
	 * @param uuid the training's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training
	 * @throws PortalException if a matching training could not be found
	 */
	@Override
	public com.liferay.kris.thoughtmachine.model.Training
			getTrainingByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.getTrainingByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTrainings(int start, int end) {

		return _trainingLocalService.getTrainings(start, end);
	}

	/**
	 * Returns all the trainings matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainings
	 * @param companyId the primary key of the company
	 * @return the matching trainings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTrainingsByUuidAndCompanyId(String uuid, long companyId) {

		return _trainingLocalService.getTrainingsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTrainingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.kris.thoughtmachine.model.Training>
					orderByComparator) {

		return _trainingLocalService.getTrainingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainings.
	 *
	 * @return the number of trainings
	 */
	@Override
	public int getTrainingsCount() {
		return _trainingLocalService.getTrainingsCount();
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
	@Override
	public com.liferay.kris.thoughtmachine.model.Training updateTraining(
		com.liferay.kris.thoughtmachine.model.Training training) {

		return _trainingLocalService.updateTraining(training);
	}

	@Override
	public TrainingLocalService getWrappedService() {
		return _trainingLocalService;
	}

	@Override
	public void setWrappedService(TrainingLocalService trainingLocalService) {
		_trainingLocalService = trainingLocalService;
	}

	private TrainingLocalService _trainingLocalService;

}
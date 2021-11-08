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
 * Provides a wrapper for {@link TrainingService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingService
 * @generated
 */
public class TrainingServiceWrapper
	implements ServiceWrapper<TrainingService>, TrainingService {

	public TrainingServiceWrapper(TrainingService trainingService) {
		_trainingService = trainingService;
	}

	@Override
	public int[] getCompleted(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _trainingService.getCompleted(serviceContext);
	}

	@Override
	public int[] getCompletedByCourseAndOrganisation(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		String courseNameSelected) {

		return _trainingService.getCompletedByCourseAndOrganisation(
			serviceContext, courseNameSelected);
	}

	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getCompletedByCourseAndOrganisationList(
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String courseNameSelected) {

		return _trainingService.getCompletedByCourseAndOrganisationList(
			serviceContext, courseNameSelected);
	}

	@Override
	public java.util.List
		<com.liferay.kris.thoughtmachine.model.TrainingCompletedUser>
			getCompletedByOrganisationList(
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _trainingService.getCompletedByOrganisationList(serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trainingService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTraining(
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _trainingService.getTraining(serviceContext);
	}

	@Override
	public java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTrainingByOrganisation(
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _trainingService.getTrainingByOrganisation(serviceContext);
	}

	@Override
	public TrainingService getWrappedService() {
		return _trainingService;
	}

	@Override
	public void setWrappedService(TrainingService trainingService) {
		_trainingService = trainingService;
	}

	private TrainingService _trainingService;

}
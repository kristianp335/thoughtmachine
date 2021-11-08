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

import java.util.List;

/**
 * Provides the remote service utility for Training. This utility wraps
 * <code>com.liferay.kris.thoughtmachine.service.impl.TrainingServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingService
 * @generated
 */
public class TrainingServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.kris.thoughtmachine.service.impl.TrainingServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
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

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<Training> getTraining(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getTraining(serviceContext);
	}

	public static List<Training> getTrainingByOrganisation(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getTrainingByOrganisation(serviceContext);
	}

	public static TrainingService getService() {
		return _service;
	}

	private static volatile TrainingService _service;

}
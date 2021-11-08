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

package com.liferay.kris.thoughtmachine.service.impl;

import com.liferay.kris.thoughtmachine.model.Training;
import com.liferay.kris.thoughtmachine.model.TrainingCompletedUser;
import com.liferay.kris.thoughtmachine.service.base.TrainingServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the training remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.kris.thoughtmachine.service.TrainingService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=thoughmachine",
		"json.web.service.context.path=Training"
	},
	service = AopService.class
)
public class TrainingServiceImpl extends TrainingServiceBaseImpl {

	public List<Training> getTraining(ServiceContext serviceContext) {
		List<Training>	apiAiData = super.trainingLocalService.getTraining(serviceContext);
		return apiAiData;		
	}
	
	public List<Training> getTrainingByOrganisation(ServiceContext serviceContext) {
		List<Training>	apiAiData = super.trainingLocalService.getTrainingByOrganisation(serviceContext);
		return apiAiData;		
	}
	
	public int[] getCompleted(ServiceContext serviceContext) {
		int[] completedNotCompleted = super.trainingLocalService.getCompleted(serviceContext);
		return completedNotCompleted;
	}
	
	public int[] getCompletedByCourseAndOrganisation(ServiceContext serviceContext, String courseNameSelected) {
		int[] completedNotCompleted = super.trainingLocalService.getCompletedByCourseAndOrganisation(serviceContext, courseNameSelected);
		return completedNotCompleted;
	}
	
	public List<Training> getCompletedByCourseAndOrganisationList(ServiceContext serviceContext, String courseNameSelected) {
		List<Training>	apiAiData = super.trainingLocalService.getCompletedByCourseAndOrganisationList(serviceContext, courseNameSelected);
		return apiAiData;		
	}
	
	
	public List<TrainingCompletedUser> getCompletedByOrganisationList(ServiceContext serviceContext) {
		List<TrainingCompletedUser> trainingCompletedUserList = super.trainingLocalService.getCompletedByOrganisationList(serviceContext);
		return trainingCompletedUserList;		
	}
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.kris.thoughtmachine.service.TrainingServiceUtil</code> to access the training remote service.
	 */
}
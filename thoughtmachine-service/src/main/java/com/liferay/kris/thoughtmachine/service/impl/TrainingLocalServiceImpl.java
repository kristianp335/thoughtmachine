package com.liferay.kris.thoughtmachine.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.kris.thoughtmachine.model.Training;
import com.liferay.kris.thoughtmachine.model.TrainingCompletedUser;
import com.liferay.kris.thoughtmachine.service.base.TrainingLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the training local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.kris.thoughtmachine.service.TrainingLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.kris.thoughtmachine.model.Training",
	service = AopService.class
)
public class TrainingLocalServiceImpl extends TrainingLocalServiceBaseImpl {
	
	public List<Training> getTraining(ServiceContext serviceContext) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long userId;
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		if (permissionChecker.isOmniadmin()) {
		
		
		userId = 41828;
		
		}
		else {
			userId = serviceContext.getUserId();
		}
		
		return super.trainingPersistence.findByByUser(userId);		
	}
	
	public int[] getCompleted(ServiceContext serviceContext) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long userId;
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		if (permissionChecker.isOmniadmin()) {
		
		
		userId = 41828;
		
		}
		else {
			userId = serviceContext.getUserId();
		}
		
		int[] completedNotCompleted = new int[2];
		
		completedNotCompleted[0] = super.trainingPersistence.countByByUserStatus(userId, "Completed");
		completedNotCompleted[1] = super.trainingPersistence.countByByUser(userId) - super.trainingPersistence.countByByUserStatus(userId, "Completed");
		
		return completedNotCompleted;
		
				
	}

	public List<Training> getTrainingByOrganisation(ServiceContext serviceContext) {
		long userId = serviceContext.getUserId();
		User user = null;
		long[] orgIds = null;
		long orgId = 0;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		if (permissionChecker.isOmniadmin()) {
			orgId = 41546;
			System.out.println(orgId);
		}
		else {
		try {
			orgIds = user.getOrganizationIds();
			orgId = orgIds[0];
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		
		System.out.println("Org id is " + orgId);
		
		return super.trainingPersistence.findByOrganisation(orgId);
	}
	
	public int[] getCompletedByCourseAndOrganisation(ServiceContext serviceContext, String courseNameSelected) {
		
		long userId = serviceContext.getUserId();
		User user = null;
		long[] orgIds = null;
		long orgId = 0;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		if (permissionChecker.isOmniadmin()) {
			orgId = 41546;
			System.out.println(orgId);
		}
		else {
		try {
			orgIds = user.getOrganizationIds();
			orgId = orgIds[0];
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		int[] completedNotCompleted = new int[2];
		
		completedNotCompleted[0] = super.trainingPersistence.countByCourseNameCourseStatusOrganisation(courseNameSelected, "Completed", orgId);
		completedNotCompleted[1] = super.trainingPersistence.countByCourseNameCourseStatusOrganisation(courseNameSelected, "In Progress", orgId) + super.trainingPersistence.countByCourseNameCourseStatusOrganisation(courseNameSelected, "Subscribed", orgId);
		
		return completedNotCompleted;
		
		
	}
	
public List<Training> getCompletedByCourseAndOrganisationList(ServiceContext serviceContext, String courseNameSelected) {
		
		long userId = serviceContext.getUserId();
		User user = null;
		long[] orgIds = null;
		long orgId = 0;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		if (permissionChecker.isOmniadmin()) {
			orgId = 41546;
			System.out.println(orgId);
		}
		else {
		try {
			orgIds = user.getOrganizationIds();
			orgId = orgIds[0];
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		int[] completedNotCompleted = new int[2];
		
		List<Training> trainingList = super.trainingPersistence.findByCourseNameOrganisation(courseNameSelected, orgId);
		
		return trainingList;
		
		
	}

	public List<TrainingCompletedUser> getCompletedByOrganisationList(ServiceContext serviceContext) {
		 
		List<TrainingCompletedUser> trainingCompletedUserList = new ArrayList<TrainingCompletedUser>();
		long userId = serviceContext.getUserId();
		User user = null;
		long[] orgIds = null;
		long orgId = 0;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		if (permissionChecker.isOmniadmin()) {
			orgId = 41546;
			System.out.println(orgId);
		}
		else {
		try {
			orgIds = user.getOrganizationIds();
			orgId = orgIds[0];
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		DynamicQuery dynamicQuery = super.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("organisation", orgId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("courseStatus", "Completed"));
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

	    projectionList.add(ProjectionFactoryUtil.groupProperty("userName"));	    
	    projectionList.add(ProjectionFactoryUtil.rowCount());
	    
	    dynamicQuery.setProjection(projectionList);
	    
	    List<Object[]> results = super.dynamicQuery(dynamicQuery);
	    
	    System.out.println("results length is" + results.size());
	    
	   
	    
	    for(Object[] result : results) {
	    	  TrainingCompletedUser thisTrainingCompletedUser = new TrainingCompletedUser();
	    	  final long completedValue = (long) result[1];	    	  
	    	  thisTrainingCompletedUser.setUsername(result[0].toString());
	    	  
	    	  thisTrainingCompletedUser.setCompleted(completedValue);
	    	  trainingCompletedUserList.add(thisTrainingCompletedUser);
	    }		
		
		return trainingCompletedUserList;
	
	}
	
	
	
}
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

package com.liferay.kris.thoughtmachine.service.http;

import com.liferay.kris.thoughtmachine.service.TrainingServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>TrainingServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingServiceSoap
 * @generated
 */
public class TrainingServiceHttp {

	public static java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTraining(
			HttpPrincipal httpPrincipal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				TrainingServiceUtil.class, "getTraining",
				_getTrainingParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.kris.thoughtmachine.model.Training>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getTrainingByOrganisation(
			HttpPrincipal httpPrincipal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				TrainingServiceUtil.class, "getTrainingByOrganisation",
				_getTrainingByOrganisationParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.kris.thoughtmachine.model.Training>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int[] getCompleted(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				TrainingServiceUtil.class, "getCompleted",
				_getCompletedParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (int[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int[] getCompletedByCourseAndOrganisation(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		String courseNameSelected) {

		try {
			MethodKey methodKey = new MethodKey(
				TrainingServiceUtil.class,
				"getCompletedByCourseAndOrganisation",
				_getCompletedByCourseAndOrganisationParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext, courseNameSelected);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (int[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.kris.thoughtmachine.model.Training>
		getCompletedByCourseAndOrganisationList(
			HttpPrincipal httpPrincipal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String courseNameSelected) {

		try {
			MethodKey methodKey = new MethodKey(
				TrainingServiceUtil.class,
				"getCompletedByCourseAndOrganisationList",
				_getCompletedByCourseAndOrganisationListParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext, courseNameSelected);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.kris.thoughtmachine.model.Training>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.kris.thoughtmachine.model.TrainingCompletedUser>
			getCompletedByOrganisationList(
				HttpPrincipal httpPrincipal,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				TrainingServiceUtil.class, "getCompletedByOrganisationList",
				_getCompletedByOrganisationListParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.kris.thoughtmachine.model.TrainingCompletedUser>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TrainingServiceHttp.class);

	private static final Class<?>[] _getTrainingParameterTypes0 = new Class[] {
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getTrainingByOrganisationParameterTypes1 =
		new Class[] {com.liferay.portal.kernel.service.ServiceContext.class};
	private static final Class<?>[] _getCompletedParameterTypes2 = new Class[] {
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[]
		_getCompletedByCourseAndOrganisationParameterTypes3 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class, String.class
		};
	private static final Class<?>[]
		_getCompletedByCourseAndOrganisationListParameterTypes4 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class, String.class
		};
	private static final Class<?>[]
		_getCompletedByOrganisationListParameterTypes5 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}
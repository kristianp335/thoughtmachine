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

package com.liferay.kris.thoughtmachine.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.kris.thoughtmachine.service.http.TrainingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TrainingSoap implements Serializable {

	public static TrainingSoap toSoapModel(Training model) {
		TrainingSoap soapModel = new TrainingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTrainingId(model.getTrainingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOrganisation(model.getOrganisation());
		soapModel.setCourseName(model.getCourseName());
		soapModel.setCourseStatus(model.getCourseStatus());
		soapModel.setCourseProgression(model.getCourseProgression());
		soapModel.setCoursePercentage(model.getCoursePercentage());

		return soapModel;
	}

	public static TrainingSoap[] toSoapModels(Training[] models) {
		TrainingSoap[] soapModels = new TrainingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrainingSoap[][] toSoapModels(Training[][] models) {
		TrainingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TrainingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrainingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrainingSoap[] toSoapModels(List<Training> models) {
		List<TrainingSoap> soapModels = new ArrayList<TrainingSoap>(
			models.size());

		for (Training model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrainingSoap[soapModels.size()]);
	}

	public TrainingSoap() {
	}

	public long getPrimaryKey() {
		return _trainingId;
	}

	public void setPrimaryKey(long pk) {
		setTrainingId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTrainingId() {
		return _trainingId;
	}

	public void setTrainingId(long trainingId) {
		_trainingId = trainingId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getOrganisation() {
		return _organisation;
	}

	public void setOrganisation(long organisation) {
		_organisation = organisation;
	}

	public String getCourseName() {
		return _courseName;
	}

	public void setCourseName(String courseName) {
		_courseName = courseName;
	}

	public String getCourseStatus() {
		return _courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		_courseStatus = courseStatus;
	}

	public int getCourseProgression() {
		return _courseProgression;
	}

	public void setCourseProgression(int courseProgression) {
		_courseProgression = courseProgression;
	}

	public int getCoursePercentage() {
		return _coursePercentage;
	}

	public void setCoursePercentage(int coursePercentage) {
		_coursePercentage = coursePercentage;
	}

	private String _uuid;
	private long _trainingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _organisation;
	private String _courseName;
	private String _courseStatus;
	private int _courseProgression;
	private int _coursePercentage;

}
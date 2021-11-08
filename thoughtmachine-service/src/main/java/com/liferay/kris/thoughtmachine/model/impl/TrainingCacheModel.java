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

package com.liferay.kris.thoughtmachine.model.impl;

import com.liferay.kris.thoughtmachine.model.Training;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Training in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TrainingCacheModel
	implements CacheModel<Training>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TrainingCacheModel)) {
			return false;
		}

		TrainingCacheModel trainingCacheModel = (TrainingCacheModel)object;

		if (trainingId == trainingCacheModel.trainingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, trainingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", trainingId=");
		sb.append(trainingId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", organisation=");
		sb.append(organisation);
		sb.append(", courseName=");
		sb.append(courseName);
		sb.append(", courseStatus=");
		sb.append(courseStatus);
		sb.append(", courseProgression=");
		sb.append(courseProgression);
		sb.append(", coursePercentage=");
		sb.append(coursePercentage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Training toEntityModel() {
		TrainingImpl trainingImpl = new TrainingImpl();

		if (uuid == null) {
			trainingImpl.setUuid("");
		}
		else {
			trainingImpl.setUuid(uuid);
		}

		trainingImpl.setTrainingId(trainingId);
		trainingImpl.setGroupId(groupId);
		trainingImpl.setCompanyId(companyId);
		trainingImpl.setUserId(userId);

		if (userName == null) {
			trainingImpl.setUserName("");
		}
		else {
			trainingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			trainingImpl.setCreateDate(null);
		}
		else {
			trainingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			trainingImpl.setModifiedDate(null);
		}
		else {
			trainingImpl.setModifiedDate(new Date(modifiedDate));
		}

		trainingImpl.setOrganisation(organisation);

		if (courseName == null) {
			trainingImpl.setCourseName("");
		}
		else {
			trainingImpl.setCourseName(courseName);
		}

		if (courseStatus == null) {
			trainingImpl.setCourseStatus("");
		}
		else {
			trainingImpl.setCourseStatus(courseStatus);
		}

		trainingImpl.setCourseProgression(courseProgression);
		trainingImpl.setCoursePercentage(coursePercentage);

		trainingImpl.resetOriginalValues();

		return trainingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		trainingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		organisation = objectInput.readLong();
		courseName = objectInput.readUTF();
		courseStatus = objectInput.readUTF();

		courseProgression = objectInput.readInt();

		coursePercentage = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(trainingId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(organisation);

		if (courseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(courseName);
		}

		if (courseStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(courseStatus);
		}

		objectOutput.writeInt(courseProgression);

		objectOutput.writeInt(coursePercentage);
	}

	public String uuid;
	public long trainingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long organisation;
	public String courseName;
	public String courseStatus;
	public int courseProgression;
	public int coursePercentage;

}
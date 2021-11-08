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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ThoughMachine_Training&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Training
 * @generated
 */
public class TrainingTable extends BaseTable<TrainingTable> {

	public static final TrainingTable INSTANCE = new TrainingTable();

	public final Column<TrainingTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Long> trainingId = createColumn(
		"trainingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TrainingTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Long> organisation = createColumn(
		"organisation", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, String> courseName = createColumn(
		"courseName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, String> courseStatus = createColumn(
		"courseStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Integer> courseProgression =
		createColumn(
			"courseProgression", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Integer> coursePercentage = createColumn(
		"coursePercentage", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private TrainingTable() {
		super("ThoughMachine_Training", TrainingTable::new);
	}

}
create table ThoughMachine_Training (
	uuid_ VARCHAR(75) null,
	trainingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	organisation LONG,
	courseName VARCHAR(500) null,
	courseStatus VARCHAR(75) null,
	courseProgression INTEGER,
	coursePercentage INTEGER
);
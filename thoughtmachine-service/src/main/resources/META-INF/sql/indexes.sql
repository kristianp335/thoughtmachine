create index IX_E48843DC on ThoughMachine_Training (courseName[$COLUMN_LENGTH:500$], courseStatus[$COLUMN_LENGTH:75$], organisation);
create index IX_F7C275BB on ThoughMachine_Training (courseName[$COLUMN_LENGTH:500$], organisation);
create index IX_1EC5581 on ThoughMachine_Training (organisation);
create index IX_D1773F8E on ThoughMachine_Training (userId, courseStatus[$COLUMN_LENGTH:75$]);
create index IX_960969A7 on ThoughMachine_Training (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EE5E2DE9 on ThoughMachine_Training (uuid_[$COLUMN_LENGTH:75$], groupId);
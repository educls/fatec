create table DEPARTMENT (
	DEPTNO char(3) not null primary key,
	DEPTNAME varchar(36) not null,
	MGRNO char(6),
	ADMRDEPT char(3) not null,
	LOCATION char(5)
);

create table EMPLOYEE (
	EMPNO char(6) not null primary key,
	FIRSTNME varchar(20) not null,
	MIDINIT char(1),
	LASTNAME varchar(15) not null,
	WORKDEPT char(3),
	PHONENO char(4),
	HIREDATE date,
	JOB char(8),
	EDLEVEL smallint,
	SEX char(1),
	BIRTHDATE date,
	SALARY decimal(9,2),
	BONUS decimal(9,2),
	COMM decimal(9,2),
	
	constraint foreign key FK_WORKDEPT(WORKDEPT) 
		references DEPARTMENT(DEPTNO)
);

create table PROJECT (
	PROJNO char(6) not null primary key,
	PROJNAME varchar(24) not null,
	DEPTNO char(3) not null,
	RESPEMP char(6) not null,
	PRSTAFF decimal(5,2),
	PRSTDATE date,
	PRENDATE date,
	MAJPROJ char(6),
	
	constraint foreign key FK_DEPTNO(DEPTNO) 
		references DEPARTMENT(DEPTNO),
	constraint foreign key FK_RESPEMP(RESPEMP) 
		references EMPLOYEE(EMPNO)
);

create table EMP_ACT (
	EMPNO char(6) not null,
	PROJNO char(6) not null,
	ACTNO smallint not null,
	EMPTIME decimal(5,2),
	EMSTDATE date,
	EMENDATE date,
	
	constraint foreign key FK_EMPNO(EMPNO) 
		references EMPLOYEE(EMPNO),
	constraint foreign key FK_PROJNO(PROJNO) 
		references PROJECT(PROJNO)
);

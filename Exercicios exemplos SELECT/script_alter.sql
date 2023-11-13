alter table DEPARTMENT 
	add foreign key(MGRNO) references EMPLOYEE(EMPNO);
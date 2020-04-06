CREATE TABLE PERSONS(
                        id INT not null IDENTITY(1,1) ,
                        personFirstName varchar(25),
                        personSecondName varchar(25),
                        personThirdName varchar(25),
		 personFamilyName varchar(25),
		 personSex number,
	     personStatus number,
		 personBirthdate varchar(25),
		 personIdType number,
	     personIdNo number ,
		 personEmail varchar(25),
		 personMobile varchar(25),
		 personAddress varchar(50)
);


CREATE TABLE GROUP_PERMISSIONS(
                                  ID NUMBER NOT NULL,
                                  GROUP_NAME VARCHAR(100),
                                  EMPLOYEES VARCHAR(500)
);

ALTER TABLE GROUP_PERMISSIONS ADD PRIMARY KEY (ID);


CREATE TABLE WORKFLOW(
                         ID NUMBER NOT NULL,
                         PRIORITY NUMBER NOT NULL,
                         GROUP_ID NUMBER,
                         ACTION varchar(2)
);

ALTER TABLE WORKFLOW
    ADD PRIMARY KEY (ID,PRIORITY);

ALTER TABLE WORKFLOW
    ADD FOREIGN KEY (GROUP_ID)
        REFERENCES GROUP_PERMISSIONS(ID);






CREATE TABLE APPROVAL_PATH(
                              USER_NID NUMBER NOT NULL,
                              WORKFLOW NUMBER NOT NULL
);

ALTER TABLE APPROVAL_PATH
    ADD PRIMARY KEY(USER_NID,WORKFLOW);
-- ALTER TABLE APPROVAL_PATH
-- ADD FOREIGN KEY (WORKFLOW)
-- REFERENCES WORKFLOW(workflow_ID);

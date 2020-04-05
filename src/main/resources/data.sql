
insert into PERSONS(personFirstName,personSecondName,personThirdName,personFamilyName ,personSex ,personStatus ,personBirthdate,personIdType ,personIdNo ,personEmail ,personMobile ,personAddress) 
values('خالد','محمد','عثمان','اباحسين' ,0 ,0 ,'2017-06-01',0 ,102661722 ,'khalid@sfd.gov.sa' ,'+9665553522' ,'حي الملك فهد') ;

insert into PERSONS(personFirstName,personSecondName,personThirdName,personFamilyName ,personSex ,personStatus ,personBirthdate,personIdType ,personIdNo ,personEmail ,personMobile ,personAddress) 
values('خالد','محمد','عثمان','اباحسين' ,0 ,0 ,'2017-06-01',0 ,102661722 ,'khalid@sfd.gov.sa' ,'+9665553522' ,'حي الملك فهد') ;




INSERT INTO GROUP_PERMISSIONS (ID, GROUP_NAME, EMPLOYEES)
VALUES ( 1111111, 'IT_MANAGER', '1045111123,1023122332' );


INSERT INTO GROUP_PERMISSIONS (ID, GROUP_NAME, EMPLOYEES)
VALUES ( 11111112, 'HR_LEAVING', '1045111122,1023122332' );


INSERT INTO WORKFLOW (ID, PRIORITY, GROUP_ID, ACTION)
VALUES ( 1234, 1,  1111111,'A');

INSERT INTO WORKFLOW (ID, PRIORITY, GROUP_ID, ACTION)
VALUES ( 1234, 2, 11111112,'C' );


INSERT INTO APPROVAL_PATH (USER_NID, WORKFLOW) VALUES ( 1045167143, 1234 );


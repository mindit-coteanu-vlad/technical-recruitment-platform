DELETE from interview_status;
DELETE from user_roles;
DELETE from USERS;
DELETE from INTERVIEWS;
DELETE FROM INTERVIEW_QUESTIONS;

INSERT INTO interview_status VALUES (1, 'NOT_STARTED');

INSERT INTO user_roles VALUES (1,'CANDIDATE');

INSERT INTO USERS VALUES (12,'12avc3' ,'Coteanu Vlad' ,'parola' ,1);

INSERT INTO USERS VALUES (13,'12avc4' ,'Beatrice Luca' ,'parola' ,1);

INSERT INTO INTERVIEWS VALUES(1, null, 12, 1);

INSERT INTO INTERVIEWS VALUES(2, null, 13, 1);

INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (1,1);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (1,2);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (1,3);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (1,4);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (1,5);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (1,6);



INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (2,1);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (2,2);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (2,3);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (2,4);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (2,5);
INSERT INTO INTERVIEW_QUESTIONS (INTERVIEW_ID, QUESTION_ID) VALUES (2,6);



DELETE from interview_status;
DELETE from user_roles;
DELETE from USERS;
DELETE from INTERVIEWS;

INSERT INTO interview_status VALUES (
	1,
    'IN_PROGRESS'
);

INSERT INTO INTERVIEWS VALUES(
	1,
    sysdate(),
	12,
    1
);

INSERT INTO user_roles VALUES (
	1,
    'CANDIDATE'
);

INSERT INTO USERS VALUES (
	12,
    '12avc3',
    'Coteanu Vlad',
    'parola',
    1
)

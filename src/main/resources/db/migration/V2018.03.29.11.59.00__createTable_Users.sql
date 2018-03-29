CREATE TABLE IF NOT EXISTS technical_recruitment_platform_db.USERS(

    USER_ID INT PRIMARY KEY auto_increment,
    USER_NAME varchar(100) NOT NULL,
    USER_PASSWORD varchar(100) NOT NULL,
    ROLE_ID varchar(100) NOT NULL

)

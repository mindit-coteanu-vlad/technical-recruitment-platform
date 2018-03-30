CREATE TABLE IF NOT EXISTS technical_recruitment_platform_db.INTERVEWS(

    ID int PRIMARY KEY auto_increment,
    START_DATE datetime,
    USER_ID int NOT NULL,
    STATUS_ID varchar(100) NOT NULL

)

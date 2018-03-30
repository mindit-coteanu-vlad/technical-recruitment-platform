
   /* ********************************************************************************************************
    * Date    ROCKET - TRP                                                                                   *
    * ------------------------------------------------------------------------------------------------------ *
    * Mar 30 2018 initial version                                                                            *
    *                                                                                                        *
    ******************************************************************************************************* */

USE technical_recruitment_platform_db;

        CREATE TABLE IF NOT EXISTS  question_types  (
            TYPE_ID  INT,
            TYPE_DE  VARCHAR(90) NOT NULL,
			CONSTRAINT  PK_TYPE_ID  PRIMARY KEY ( TYPE_ID )
        );

   /* ********************************************************************************************************
    * Date    ROCKET - TRP                                                                                   *
    * ------------------------------------------------------------------------------------------------------ *
    * Mar 30 2018 initial version                                                                            *
    *                                                                                                        *
    ******************************************************************************************************* */

USE technical_recruitment_platform_db;

        CREATE TABLE IF NOT EXISTS `questions` (
            `QUESTION_ID` INT AUTO_INCREMENT,
            `QUESTION_TITLE` TEXT NOT NULL,
			`MULTIPLE_ANSWERS` TINYINT(1) DEFAULT 0 NOT NULL,
			`QUESTION_TYPE` INT NOT NULL,
			CONSTRAINT `PK_QUESTION_ID` PRIMARY KEY (`QUESTION_ID`)
			-- , CONSTRAINT `FK_QUESTION_TYPE` FOREIGN KEY(`QUESTION_TYPE`)
			-- REFERENCES `QUESTION_TYPES`(`TYPE_ID`)
        );
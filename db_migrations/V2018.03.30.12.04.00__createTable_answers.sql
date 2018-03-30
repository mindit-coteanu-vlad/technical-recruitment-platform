
   /* ********************************************************************************************************
    * Date    ROCKET - TRP                                                                                   *
    * ------------------------------------------------------------------------------------------------------ *
    * Mar 30 2018 initial version                                                                            *
    *                                                                                                        *
    ******************************************************************************************************* */

USE technical_recruitment_platform_db;

        CREATE TABLE IF NOT EXISTS `answers` (
            `ANSWER_ID` INT AUTO_INCREMENT,
			`QUESTION_ID` INT NOT NULL,
			`ANSWER_DE` TEXT NOT NULL,
			`CORRECT` TINYINT(1) NOT NULL,
			CONSTRAINT `PK_ANSWER_ID` PRIMARY KEY (`ANSWER_ID`)
			-- , CONSTRAINT `FK_QUESTION_ID` FOREIGN KEY (`QUESTION_ID`)
			-- REFERENCES `QUESTIONS`(`QUESTION_ID`)
        );
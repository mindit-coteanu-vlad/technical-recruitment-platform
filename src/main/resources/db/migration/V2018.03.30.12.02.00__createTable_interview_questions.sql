
   /* ********************************************************************************************************
    * Date    ROCKET - TRP                                                                                   *
    * ------------------------------------------------------------------------------------------------------ *
    * Mar 30 2018 initial version                                                                            *
    *                                                                                                        *
    ******************************************************************************************************* */

USE technical_recruitment_platform_db;

        CREATE TABLE IF NOT EXISTS `interview_questions` (
            `INTERVIEW_ID` INT NOT NULL,
			`QUESTION_ID` INT NOT NULL,
			`USER_ANSWER` TEXT,
			`IS_CORRECT` TINYINT(1),
			`TECHNICAL_SCORE` TINYINT(1),
			`EVALUATOR_SCORE` TINYINT(1),
			`STATUS` TINYINT(1),
			CONSTRAINT `PK_INTERVIEW_QUESTION` PRIMARY KEY (`INTERVIEW_ID`, `QUESTION_ID`)
			-- , CONSTRAINT `FK_INTERVIEW_ID` FOREIGN KEY (`INTERVIEW_ID`)
			-- REFERENCES `INTERVIEW`(`INTERVIEW_ID`),
			-- CONSTRAINT `FK_QUESTION_ID` FOREIGN KEY (`QUESTION_ID`)
			-- REFERENCES `QUESTIONS`(`QUESTION_ID`)
			
        );
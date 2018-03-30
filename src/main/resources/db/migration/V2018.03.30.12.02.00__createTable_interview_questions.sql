
   /* ********************************************************************************************************
    * Date    ROCKET - TRP                                                                                   *
    * ------------------------------------------------------------------------------------------------------ *
    * Mar 30 2018 initial version                                                                            *
    *                                                                                                        *
    ******************************************************************************************************* */

USE technical_recruitment_platform_db;

        CREATE TABLE IF NOT EXISTS interview_questions (
            INTERVIEW_ID INT,
			QUESTION_ID INT,
			CANDIDATE_ANSWER_TEXT TEXT,
			TECHNICAL_REVIEW TEXT,
			IS_CORRECT TINYINT(1),
			TECHNICAL_SCORE TINYINT(1),
			EVALUATOR_SCORE TINYINT(1),
			SUBMITTED TINYINT(1),
			STATUS TINYINT(1),
			PRIMARY KEY (INTERVIEW_ID, QUESTION_ID)

        );
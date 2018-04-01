
   /* ********************************************************************************************************
    * Date    ROCKET - TRP                                                                                   *
    * ------------------------------------------------------------------------------------------------------ *
    * Mar 30 2018 initial version                                                                            *
    *                                                                                                        *
    ******************************************************************************************************* */

USE technical_recruitment_platform_db;

        CREATE TABLE IF NOT EXISTS answers (
            ANSWER_ID INT AUTO_INCREMENT,
			QUESTION_ID INT NOT NULL,
			ANSWER_DE TEXT NOT NULL,
      CORRECT INT,
			PRIMARY KEY (ANSWER_ID)

        );
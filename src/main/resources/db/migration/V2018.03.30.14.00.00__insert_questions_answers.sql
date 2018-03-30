
   /* ********************************************************************************************************
    * Date    ROCKET - TRP                                                                                   *
    * ------------------------------------------------------------------------------------------------------ *
    * Mar 30 2018 initial version                                                                            *
    *                                                                                                        *
    ******************************************************************************************************* */

USE technical_recruitment_platform_db;
DELETE FROM question_types WHERE TYPE_ID > 0;
DELETE FROM questions WHERE QUESTION_ID > 0;
DELETE FROM answers WHERE ANSWER_ID > 0;


INSERT INTO question_types(TYPE_DE) VALUES('CHOOSE_ANSWER');
INSERT INTO question_types(TYPE_DE) VALUES('WRITE_ANSWER');
INSERT INTO question_types(TYPE_DE) VALUES('WRITE_CODE');





INSERT INTO questions(QUESTION_TITLE, MULTIPLE_ANSWERS, QUESTION_TYPE) VALUES('What will be the output of the program? \r\n
class Equals \r\n
{ \r\n
public static void main(String [] args) \r\n
{ \r\n
int x = 100; \r\n
double y = 100.1; \r\n
boolean b = (x = y); /* Line 7 */ \r\n
System.out.println(b); \r\n
} \r\n
}', 0, 1);
INSERT INTO answers(QUESTION_ID, ANSWER_DE, CORRECT) VALUES(1, 'true', 0);
INSERT INTO answers(QUESTION_ID, ANSWER_DE, CORRECT) VALUES(1, 'false', 0);
INSERT INTO answers(QUESTION_ID, ANSWER_DE, CORRECT) VALUES(1, 'Compilation fails', 0);
INSERT INTO answers(QUESTION_ID, ANSWER_DE, CORRECT) VALUES(1, 'An exception is thrown at runtime', 0);




INSERT INTO questions(QUESTION_TITLE, MULTIPLE_ANSWERS, QUESTION_TYPE) VALUES('which statement is true for: \r\n
class Test1 \r\n
{ \r\n
public int value; \r\n
public int hashCode() { return 42; } \r\n
} \r\n
class Test2 \r\n
{ \r\n
public int value; \r\n
public int hashcode() { return (int)(value^5); } \r\n
}', 0, 1);
INSERT INTO answers(QUESTION_ID, ANSWER_DE, CORRECT) VALUES(2, 'class Test1 will not compile.', 0);
INSERT INTO answers(QUESTION_ID, ANSWER_DE, CORRECT) VALUES(2, 'The Test1 hashCode() method is more efficient than the Test2 hashCode() method.', 0);
INSERT INTO answers(QUESTION_ID, ANSWER_DE, CORRECT) VALUES(2, 'The Test1 hashCode() method is less efficient than the Test2 hashCode() method.', 0);
INSERT INTO answers(QUESTION_ID, ANSWER_DE, CORRECT) VALUES(2, 'class Test2 will not compile.', 0);



INSERT INTO questions(QUESTION_TITLE, MULTIPLE_ANSWERS, QUESTION_TYPE) VALUES('Q: What are top 2-3 advantages of writing unit tests?', 0, 2);
INSERT INTO questions(QUESTION_TITLE, MULTIPLE_ANSWERS, QUESTION_TYPE) VALUES('Q: What’s the difference between a ClassNotFoundException and NoClassDefFoundError?', 0, 2);


INSERT INTO questions(QUESTION_TITLE, MULTIPLE_ANSWERS, QUESTION_TYPE) VALUES('How do you reverse String("Java Programming") without using Iteration and Recursion?', 0, 3);
INSERT INTO questions(QUESTION_TITLE, MULTIPLE_ANSWERS, QUESTION_TYPE) VALUES('Write a simple unit test:', 0, 3);


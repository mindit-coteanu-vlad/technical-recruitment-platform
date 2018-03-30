package com.technical.recruitment.platform.dao.impl;

import com.technical.recruitment.platform.dao.QuestionsDAO;
import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.model.Question;
import com.technical.recruitment.platform.model.questionTypes.QuestionChooseAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteCode;
import com.technical.recruitment.platform.util.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcQuestionsDAO implements QuestionsDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Question> getAllQuestionsByInterviewId(Integer interviewId) {
        String sqlSelect = "SELECT   " +
                "interviews.ID,  " +
                "    interviews.START_DATE,  " +
                "    status.STATUS_DE  " +
                "FROM technical_recruitment_platform_db.interviews interviews    " +
                "INNER JOIN technical_recruitment_platform_db.INTERVIEW_STATUS status        " +
                "ON status.STATUS_ID = interviews.STATUS_ID        " +
                "WHERE interviews.USER_ID = :userId";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("interviewId", interviewId);

        return jdbcTemplate.execute(sqlSelect, namedParameters, preparedStatement -> {
            ResultSet rs = preparedStatement.executeQuery();

            List<Question> results = new ArrayList<>();
            while(rs.next()) {

                Question question;

                String questionType = rs.getString("TYPE_DE");
                switch (questionType) {
                    case "CHOOSE_ANSWER":
                        question = new QuestionChooseAnswer();
                        question.setType(QuestionType.CHOOSE_ANSWER);
                        break;
                    case "WRITE_ANSWER":
                        question = new QuestionWriteAnswer();
                        question.setType(QuestionType.WRITE_ANSWER);
                        break;
                    case "WRITE_CODE":
                        question = new QuestionWriteCode();
                        question.setType(QuestionType.WRITE_CODE);
                        break;
                    default:
                        //NEVER HAPPENS
                        question = new QuestionWriteCode();
                }

                question.setId(rs.getInt("QUESTION_ID"));
                question.setTitle("QUESTION_TITLE");
                results.add(question);
            }
            return results;
        });
    }



}
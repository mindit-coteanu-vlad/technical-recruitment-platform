package com.technical.recruitment.platform.dao.impl;

import com.technical.recruitment.platform.dao.AnswerDAO;
import com.technical.recruitment.platform.model.Answer;
import com.technical.recruitment.platform.model.Question;
import com.technical.recruitment.platform.model.questionTypes.QuestionChooseAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteCode;
import com.technical.recruitment.platform.util.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcAnswerDAO implements AnswerDAO{

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<Answer> getAnswersForQuestion(Integer questionId) {
        String sqlSelect = "SELECT     " +
                "answer.ANSWER_ID,    " +
                "    answer.QUESTION_ID,    " +
                "    answer.ANSWER_DE,    " +
                "    answer.CORRECT    " +
                "FROM technical_recruitment_platform_db.ANSWERS  answer  " +
                "WHERE answer.QUESTION_ID = :questionId";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("questionId", questionId);

        return jdbcTemplate.execute(sqlSelect, namedParameters, preparedStatement -> {
            ResultSet rs = preparedStatement.executeQuery();

            List<Answer> results = new ArrayList<>();
            while(rs.next()) {

                Answer answer = new Answer();
                answer.setId(rs.getInt("ANSWER_ID"));
                answer.setIdQuestion(rs.getInt("QUESTION_ID"));
                answer.setCorrect(rs.getBoolean("CORRECT"));
                answer.setLabel(rs.getString("ANSWER_DE"));
                results.add(answer);
            }
            return results;
        });
    }
}

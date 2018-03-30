package com.technical.recruitment.platform.dao;

import com.technical.recruitment.platform.model.Answer;

import java.util.List;

public interface AnswerDAO {

    List<Answer> getAnswersForQuestion(Integer questionId);

}

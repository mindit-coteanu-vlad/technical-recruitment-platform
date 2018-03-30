package com.technical.recruitment.platform.dao;

import com.technical.recruitment.platform.model.Question;

import java.util.List;

public interface QuestionsDAO {

    List<Question> getAllQuestionsByInterviewId(Integer interviewId);

}

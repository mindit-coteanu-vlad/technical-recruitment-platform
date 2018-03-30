package com.technical.recruitment.platform.service;

import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.model.Question;

import java.util.List;

public interface InterviewService {

    Interview getInterviewWithQuestions(Integer userId);

    List<Question> getQuestionsByInterviewId(Integer interviewId);

}

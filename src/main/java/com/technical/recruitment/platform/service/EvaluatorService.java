package com.technical.recruitment.platform.service;

import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.model.Question;
import com.technical.recruitment.platform.model.Response;
import com.technical.recruitment.platform.model.questionTypes.QuestionChooseAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteCode;

import java.io.IOException;
import java.util.List;


public interface EvaluatorService {

    List<Question> evaluateInterview(Interview interview);

    Response evaluateQuestionChooseAnswer(QuestionChooseAnswer question);

    Response evaluateQuestionWriteAnswer(QuestionWriteAnswer question);

    Response evaluateQuestionWriteCode(QuestionWriteCode question);

    String evaluateQuestionWriteCode(String answerCode) throws IOException;


}

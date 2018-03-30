package com.technical.recruitment.platform.service.impl;

import com.technical.recruitment.platform.dao.AnswerDAO;
import com.technical.recruitment.platform.dao.InterviewDAO;
import com.technical.recruitment.platform.dao.QuestionsDAO;
import com.technical.recruitment.platform.model.Answer;
import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.model.Question;
import com.technical.recruitment.platform.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService{

    @Autowired
    private InterviewDAO interviewDAO;

    @Autowired
    private QuestionsDAO questionsDAO;

    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public Interview getInterviewWithQuestions(Integer userId) {

        Interview interview = interviewDAO.getInterviewByUserId(userId);
        List<Question> questionList = getQuestionsByInterviewId(interview.getId());
        for (Question question:questionList) {
            question.setAnswers(answerDAO.getAnswersForQuestion(question.getId()));
        }
        interview.setQuestionList(questionList);
        return interview;

    }

    @Override
    public List<Question> getQuestionsByInterviewId(Integer interviewId) {
        return questionsDAO.getAllQuestionsByInterviewId(interviewId);
    }

}

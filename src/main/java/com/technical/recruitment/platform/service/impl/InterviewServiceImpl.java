package com.technical.recruitment.platform.service.impl;

import com.technical.recruitment.platform.dao.InterviewDAO;
import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;

public class InterviewServiceImpl implements InterviewService{

    @Autowired
    private InterviewDAO interviewDAO;

    @Override
    public Interview getInterviewWithQuestions(Integer userId) {

        Interview interview = interviewDAO.getInterviewByUserId(userId);
        return interview;

    }

}

package com.technical.recruitment.platform.dao;

import com.technical.recruitment.platform.model.Interview;

public interface InterviewDAO {

    Interview getInterviewByUserId(Integer userId);

}

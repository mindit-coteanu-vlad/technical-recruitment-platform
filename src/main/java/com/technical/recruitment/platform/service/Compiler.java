package com.technical.recruitment.platform.service;

import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.model.questionTypes.QuestionChooseAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteCode;

public interface Compiler {

    void compileInterview(Interview interview);


}

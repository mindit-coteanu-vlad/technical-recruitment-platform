package com.technical.recruitment.platform.service.impl;

import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.model.Question;
import com.technical.recruitment.platform.model.questionTypes.QuestionChooseAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteCode;
import com.technical.recruitment.platform.service.Compiler;

public class CompilerImpl implements Compiler {

    @Override
    public void compileInterview(Interview interview) {

        for (Question question : interview.getQuestionList()) {
            switch(question.getType()) {
                case CHOOSE_ANSWER:
                    compileQuestionChooseAnswer((QuestionChooseAnswer)question);
                    break;
                case WRITE_ANSWER:
                    compileQuestionWriteAnswer((QuestionWriteAnswer) question);
                    break;
                case WRITE_CODE:
                    compileQuestionWriteCode((QuestionWriteCode) question);
                    break;
            }
        }

    }

    private void compileQuestionChooseAnswer(QuestionChooseAnswer question) {

        Double score = 0d;
        if(question.getCorrectAnswerId() != question.getUserAnswerId()) {
            score = 1d;
        }
        question.setScore(score);

    }

    private void compileQuestionWriteAnswer(QuestionWriteAnswer question) {

        int totalKeyWords = question.getKeywords().size();
        int currentMatched = 0;

        for (String keyword:question.getKeywords()) {
            if(question.getUserAnswer().toLowerCase().contains(keyword.toLowerCase())) {
                currentMatched++;
            }
        }

        question.setScore(Math.round((double) (currentMatched / totalKeyWords) * 100.0) / 100.0);

    }

    private void compileQuestionWriteCode(QuestionWriteCode question) {

    }
}

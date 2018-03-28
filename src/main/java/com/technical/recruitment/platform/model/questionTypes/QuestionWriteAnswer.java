package com.technical.recruitment.platform.model.questionTypes;

import com.technical.recruitment.platform.model.Question;

import java.util.List;

public class QuestionWriteAnswer extends Question {

    private List<String> keywords;
    private String userAnswer;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}

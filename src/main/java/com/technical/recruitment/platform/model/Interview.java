package com.technical.recruitment.platform.model;

import java.util.List;

public class Interview {

    private int id;
    private List<Question> questionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Interview() {
    }

    public Interview(int id, List<Question> questionList) {
        this.id = id;
        this.questionList = questionList;
    }
}

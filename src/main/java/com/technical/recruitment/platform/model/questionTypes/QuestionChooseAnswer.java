package com.technical.recruitment.platform.model.questionTypes;

import com.technical.recruitment.platform.model.Question;

public class QuestionChooseAnswer extends Question {

    private int correctAnswerId;
    private int userAnswerId;

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(int correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public int getUserAnswerId() {
        return userAnswerId;
    }

    public void setUserAnswerId(int userAnswerId) {
        this.userAnswerId = userAnswerId;
    }
}

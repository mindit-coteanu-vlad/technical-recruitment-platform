package com.technical.recruitment.platform.model.questionTypes;

import com.technical.recruitment.platform.model.Question;

import java.util.List;

public class QuestionChooseAnswer extends Question {

    private List<String> possibleAnswers;
    private int correctAnswer;
    private int userAnswer;

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
}

package com.technical.recruitment.platform.model;

import com.technical.recruitment.platform.util.QuestionType;

import java.util.List;

public abstract class Question {

    private int id;
    private int number;
    private String title;
    private QuestionType type;
    private String candidateAnswerText;
    private String technicalReview;
    private boolean evaluatorScore;
    private boolean technicalScore;
    private boolean submitted;
    private boolean status;
    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getTechnicalReview() {
        return technicalReview;
    }

    public void setTechnicalReview(String technicalReview) {
        this.technicalReview = technicalReview;
    }

    public boolean isEvaluatorScore() {
        return evaluatorScore;
    }

    public void setEvaluatorScore(boolean evaluatorScore) {
        this.evaluatorScore = evaluatorScore;
    }

    public boolean isTechnicalScore() {
        return technicalScore;
    }

    public void setTechnicalScore(boolean technicalScore) {
        this.technicalScore = technicalScore;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCandidateAnswerText() {
        return candidateAnswerText;
    }

    public void setCandidateAnswerText(String message) {
        this.candidateAnswerText = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }
}

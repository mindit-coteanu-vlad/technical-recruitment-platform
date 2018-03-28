package com.technical.recruitment.platform.model;

import sun.plugin2.message.Message;

public abstract class Question {

    private int id;
    private int number;
    private String title;
    private String body;
    private QuestionType type;
    private Response response;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response message) {
        this.response = message;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }
}

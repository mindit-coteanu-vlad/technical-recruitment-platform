package com.technical.recruitment.platform.model.questionTypes;

import com.technical.recruitment.platform.model.Question;

import java.io.File;

public class QuestionWriteCode extends Question{

    private String expectedOutput;
    private File userAnswerFile;

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public File getUserAnswerFile() {
        return userAnswerFile;
    }

    public void setUserAnswerFile(File userAnswerFile) {
        this.userAnswerFile = userAnswerFile;
    }
}

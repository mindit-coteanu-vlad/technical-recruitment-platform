package com.technical.recruitment.platform.controller;

import com.technical.recruitment.platform.model.Response;
import com.technical.recruitment.platform.model.questionTypes.QuestionChooseAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteCode;
import com.technical.recruitment.platform.service.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Test {

    @Autowired
    private Evaluator evaluator;


    @RequestMapping(value="/test", method = RequestMethod.GET)
    public void init() {
        QuestionChooseAnswer questionChooseAnswer = new QuestionChooseAnswer();
        questionChooseAnswer.setBody("Which of the following is not a primitive Java type?");
        questionChooseAnswer.setCorrectAnswer(2);
        questionChooseAnswer.setUserAnswer(2);


        QuestionWriteAnswer questionWriteAnswer = new QuestionWriteAnswer();
        List<String> keys = new ArrayList<>();
        keys.add("Java");
        keys.add("API");
        keys.add("Programmer");
        String userAns = "The main benefit of java is that a proGRAMMER can use classes.";
        questionWriteAnswer.setKeywords(keys);
        questionWriteAnswer.setUserAnswer(userAns);

        QuestionWriteCode questionWriteCode = new QuestionWriteCode();
        questionWriteCode.setExpectedOutput("Hello America.");

        String fileLoc = "C:/Users/Mindit/Desktop/app.java";
        File file = new File(fileLoc.replace("/", File.separator));
        questionWriteCode.setUserAnswerFile(file);

        Response response1 = evaluator.evaluateQuestionChooseAnswer(questionChooseAnswer);
        Response response2 = evaluator.evaluateQuestionWriteAnswer(questionWriteAnswer);
        Response response3 = evaluator.evaluateQuestionWriteCode(questionWriteCode);
    }



}

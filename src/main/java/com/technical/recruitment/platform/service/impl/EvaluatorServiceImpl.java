package com.technical.recruitment.platform.service.impl;

import com.technical.recruitment.platform.model.Answer;
import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.model.Question;
import com.technical.recruitment.platform.model.questionTypes.QuestionChooseAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteAnswer;
import com.technical.recruitment.platform.model.questionTypes.QuestionWriteCode;
import com.technical.recruitment.platform.service.EvaluatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluatorServiceImpl implements EvaluatorService {

    private static final Logger logger = LoggerFactory.getLogger(EvaluatorServiceImpl.class);

    @Value("${absoluteJDKPath}")
    private String absoluteJDKPath;

    @Override
    public List<Question> evaluateInterview(Interview interview) {

        logger.info("Starting evaluating the interview...");
        List<Question> evaluatedQuestions = new ArrayList<>();

        for (Question question : interview.getQuestionList()) {
            switch(question.getType()) {
                case CHOOSE_ANSWER:
                    question = evaluateQuestionChooseAnswer((QuestionChooseAnswer)question);
                    break;
                case WRITE_ANSWER:
                    question = evaluateQuestionWriteAnswer((QuestionWriteAnswer) question);
                    break;
                case WRITE_CODE:
                    question = evaluateQuestionWriteCode((QuestionWriteCode) question);
                    break;
            }
            evaluatedQuestions.add(question);
        }

        return evaluatedQuestions;
    }

    @Override
    public QuestionChooseAnswer evaluateQuestionChooseAnswer(QuestionChooseAnswer question) {

        /*logger.info("Question type: " + question.getType());

        for (Answer answer:question.getAnswers()) {
            if(question.getCandidateAnswerText())
        }*/

        return question;

    }

    @Override
    public QuestionWriteAnswer evaluateQuestionWriteAnswer(QuestionWriteAnswer question) {

        /*logger.info("Question type: " + question.getType());
        Response response = new Response();

        double totalKeyWords = question.getKeywords().size();
        double currentMatched = 0;

        for (String keyword:question.getKeywords()) {
            if(question.getUserAnswer().toLowerCase().contains(keyword.toLowerCase())) {
                currentMatched++;
            }
        }

        response.setMessage("Succesful evaluated");
        response.setScore((double) (currentMatched / totalKeyWords));*/

        return question;
    }

    @Override
    public QuestionWriteCode evaluateQuestionWriteCode(QuestionWriteCode question) {
        return question;
    }


    @Override
    public String evaluateQuestionWriteCode(String answerCode) throws IOException {

        logger.info("Evaluate question");
        Process process = null;
        BufferedWriter writer = null;
        File tempFile = null;
        BufferedReader errorReader = null;
        String response = "";
        String sCurrentLine = "";

        try {
            tempFile = new File("temp/HelloWorld.java");

            writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write(answerCode);
            logger.info("Uploaded file successfully " + tempFile.getCanonicalPath());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error on writing the java file ");
        } finally {
            try {
                // Close the writer regardless of what happens
                writer.close();
            } catch (Exception e) {
            }
        }

        Runtime.getRuntime().exec("temp/exec.bat");

        try (
            BufferedReader br = new BufferedReader(new FileReader("temp/output.txt"))) {
            while ((sCurrentLine = br.readLine()) != null) {
                response += sCurrentLine + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }
}

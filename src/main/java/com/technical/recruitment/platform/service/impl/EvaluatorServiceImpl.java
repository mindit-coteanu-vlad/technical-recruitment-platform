package com.technical.recruitment.platform.service.impl;

import com.technical.recruitment.platform.model.Interview;
import com.technical.recruitment.platform.model.Question;
import com.technical.recruitment.platform.model.Response;
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
            logger.info("Evaluating question number " + question.getNumber());
            switch(question.getType()) {
                case CHOOSE_ANSWER:
                    question.setResponse(evaluateQuestionChooseAnswer((QuestionChooseAnswer)question));
                    break;
                case WRITE_ANSWER:
                    question.setResponse(evaluateQuestionWriteAnswer((QuestionWriteAnswer) question));
                    break;
                case WRITE_CODE:
                    evaluateQuestionWriteCode((QuestionWriteCode) question);
                    break;
            }
            evaluatedQuestions.add(question);
        }

        return evaluatedQuestions;
    }

    @Override
    public Response evaluateQuestionChooseAnswer(QuestionChooseAnswer question) {

        logger.info("Question type: " + question.getType());
        Response response = new Response();

        Double score = 0d;
        if(question.getCorrectAnswer() == question.getUserAnswer()) {
            score = 1d;
        }

        response.setMessage("Succesful evaluated");
        response.setScore(score);
        return response;

    }

    @Override
    public Response evaluateQuestionWriteAnswer(QuestionWriteAnswer question) {

        logger.info("Question type: " + question.getType());
        Response response = new Response();

        double totalKeyWords = question.getKeywords().size();
        double currentMatched = 0;

        for (String keyword:question.getKeywords()) {
            if(question.getUserAnswer().toLowerCase().contains(keyword.toLowerCase())) {
                currentMatched++;
            }
        }

        response.setMessage("Succesful evaluated");
        response.setScore((double) (currentMatched / totalKeyWords));

        return response;
    }

    @Override
    public Response evaluateQuestionWriteCode(QuestionWriteCode question) {

        logger.info("Question type: " + question.getType());
        Response response = new Response();

        Process process = null;
        BufferedReader bufferedReader = null;
        BufferedReader errorReader = null;
        String filePath = question.getUserAnswerFile().getPath();
        String fileName = question.getUserAnswerFile().getName();

        try {
            logger.info("Compiling...");
            process = Runtime.getRuntime().exec("javac " + filePath);

        } catch (IOException e) {
            logger.error("Error when compiling " + filePath);
            errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            try {
                response.setMessage(errorReader.readLine());
                logger.error(response.getMessage());
            } catch (IOException e1) {
                response.setMessage("Failed to collect error.");
                logger.error(response.getMessage());
                e1.printStackTrace();
            }

            response.setScore(0d);
            e.printStackTrace();
            return response;
        }

        try {
            String executableScript = "java " + filePath;

            //Eliminate .java
            process = Runtime.getRuntime().exec("copy " + filePath);
            process = Runtime.getRuntime().exec(fileName);
        } catch (IOException e) {
            logger.error("Error when running " + filePath);
            errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            try {
                response.setMessage(errorReader.readLine());
                logger.error(response.getMessage());
            } catch (IOException e1) {
                response.setMessage("Failed to collect error.");
                logger.error(response.getMessage());
                e1.printStackTrace();
            }

            e.printStackTrace();
            response.setScore(0d);
            return response;
        }

        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        try {
            response.setMessage(bufferedReader.readLine());
            logger.info(response.getMessage());
            if(question.getExpectedOutput().equals(response.getMessage())) {
                response.setScore(1d);
            }
        } catch (IOException e) {
            response.setMessage("Failed to collect error");
            e.printStackTrace();
        }

        return response;

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

package com.technical.recruitment.platform.controller;

import com.technical.recruitment.platform.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin
@RequestMapping(value = "/trp/interview")
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @RequestMapping(value= "/getInterview", method = RequestMethod.GET)
    public ResponseEntity getInterview(@RequestParam Integer userId) {

        return new ResponseEntity(interviewService.getInterviewWithQuestions(userId), HttpStatus.ACCEPTED);

    }

}

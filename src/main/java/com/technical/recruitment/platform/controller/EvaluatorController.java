package com.technical.recruitment.platform.controller;

import com.technical.recruitment.platform.model.OutputCode;
import com.technical.recruitment.platform.service.EvaluatorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@CrossOrigin
public class EvaluatorController {

    @Autowired
    private EvaluatorService evaluatorService;


    @ApiOperation(value = "Validate Question Code")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Validate question finished successfully"),
            @ApiResponse(code = 500, message = "Error request")}
    )
    @RequestMapping(value = "/evaluateQuestionWriteCode",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity evaluateQuestionWriteCode(@RequestBody String code) throws IOException {

        if(code == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        String response = evaluatorService.evaluateQuestionWriteCode(code);
        OutputCode outputCode = new OutputCode(response);
        return new ResponseEntity(outputCode, HttpStatus.OK);

    }




}

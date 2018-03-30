package com.technical.recruitment.platform.controller;

import com.technical.recruitment.platform.dto.UserDTO;
import com.technical.recruitment.platform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/trp")
public class LoginController {

    private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/loginCandidate", method = RequestMethod.GET)
    public ResponseEntity login(@RequestParam(value = "userCode") String userCode) {

        return userService.getUserByToken(userCode)
                .map(userDTO -> {
                    LOGGER.info("Successfully retrieved user data for user {}, data={}", userCode, userDTO);
                    return new ResponseEntity<>(userDTO, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

package com.technical.recruitment.platform.controller;

import com.technical.recruitment.platform.dto.UserDTO;
import com.technical.recruitment.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/trp")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    @RequestMapping(value="/loginCandidate", method = RequestMethod.GET)
    public ResponseEntity login(@RequestParam String userCode) {

        Optional<UserDTO> optional = userService.getUserByToken(userCode);
        UserDTO userDTO = null;
        if(optional.isPresent()) {
            userDTO = optional.get();
        } else {
            return new ResponseEntity("USER_NOT_FOUND", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(userDTO.getInterviewStatus(), HttpStatus.ACCEPTED);

    }

}

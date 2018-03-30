package com.technical.recruitment.platform.service.impl;

import com.technical.recruitment.platform.dao.UserDAO;
import com.technical.recruitment.platform.dto.UserDTO;
import com.technical.recruitment.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Optional<UserDTO> getUserByToken(String userToken) {
        return userDAO.getUserByToken(userToken);
    }
}

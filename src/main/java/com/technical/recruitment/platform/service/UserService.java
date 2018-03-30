package com.technical.recruitment.platform.service;

import com.technical.recruitment.platform.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> getUserByToken(String userToken);

}

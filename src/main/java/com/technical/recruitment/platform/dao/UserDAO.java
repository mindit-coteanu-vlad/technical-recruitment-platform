package com.technical.recruitment.platform.dao;

import com.technical.recruitment.platform.dto.UserDTO;

import java.util.Optional;

public interface UserDAO {

    Optional<UserDTO> getUserByToken(String userToken);

}

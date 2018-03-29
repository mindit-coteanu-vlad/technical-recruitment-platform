package com.technical.recruitment.platform.security.dao;

import com.technical.recruitment.platform.security.dto.UserDTO;

import java.util.Optional;

public interface UserDAO {

    Optional<UserDTO> getUserByUserName(String username);

}

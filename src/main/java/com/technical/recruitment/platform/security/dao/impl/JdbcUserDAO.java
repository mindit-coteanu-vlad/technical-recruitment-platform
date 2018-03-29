package com.technical.recruitment.platform.security.dao.impl;

import com.technical.recruitment.platform.security.dao.UserDAO;
import com.technical.recruitment.platform.security.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcUserDAO implements UserDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Optional<UserDTO> getUserByUserName(String username) {

        String sqlSelect = "" +
                "SELECT " +
                "   users.USER_NAME, " +
                "   users.USER_PASSWORD," +
                "   roles.ROLE_NAME " +
                "FROM technical_recruitment_platform_db.USERS users " +
                "INNER JOIN technical_recruitment_platform_db.USER_ROLES roles " +
                "   ON users.ROLE_ID = roles.ROLE_ID " +
                "WHERE users.USER_NAME = :username ";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("username", username);

        UserDTO userDTO = null;
        try {
            userDTO = jdbcTemplate.queryForObject(sqlSelect, namedParameters, new UserDTOMapper());
        } catch (EmptyResultDataAccessException e) {

        }

        return Optional.ofNullable(userDTO);
    }

    class UserDTOMapper implements RowMapper<UserDTO> {
        @Override
        public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDTO user = new UserDTO();
            user.setUserName(rs.getString("USER_NAME"));
            user.setPassword(rs.getString("USER_PASSWORD"));
            user.setUserRole(rs.getString("ROLE_NAME"));
            return user;
        }
    }


}

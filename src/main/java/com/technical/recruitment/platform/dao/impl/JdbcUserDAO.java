package com.technical.recruitment.platform.dao.impl;

import com.technical.recruitment.platform.dao.UserDAO;
import com.technical.recruitment.platform.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class JdbcUserDAO implements UserDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Optional<UserDTO> getUserByToken(String userToken) {

        String sqlSelect = "" +
                "SELECT " +
                "   users.USER_ID " +
                "   users.USER_TOKEN, " +
                "   users.USER_NAME, " +
                "   users.USER_PASSWORD," +
                "   roles.ROLE_NAME " +
                "FROM technical_recruitment_platform_db.USERS users " +
                "INNER JOIN technical_recruitment_platform_db.USER_ROLES roles " +
                "   ON users.ROLE_ID = roles.ROLE_ID " +
                "WHERE users.USER_TOKEN = :userToken ";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("userToken", userToken);

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
            user.setId(rs.getInt("USER_ID"));
            user.setUserName(rs.getString("USER_NAME"));
            user.setUserPassword(rs.getString("USER_PASSWORD"));
            user.setUserToken(rs.getString("USER_TOKEN"));
            user.setUserRole(rs.getString("ROLE_NAME"));
            return user;
        }
    }


}

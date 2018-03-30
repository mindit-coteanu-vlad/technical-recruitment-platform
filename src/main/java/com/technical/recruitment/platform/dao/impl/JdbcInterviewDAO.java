package com.technical.recruitment.platform.dao.impl;

import com.technical.recruitment.platform.dao.InterviewDAO;
import com.technical.recruitment.platform.dto.UserDTO;
import com.technical.recruitment.platform.model.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcInterviewDAO implements InterviewDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Interview getInterviewByUserId(Integer userId) {
        String sqlSelect = "SELECT   " +
                "interviews.ID,  " +
                "    interviews.START_DATE,  " +
                "    status.STATUS_DE  " +
                "FROM technical_recruitment_platform_db.interviews interviews    " +
                "INNER JOIN technical_recruitment_platform_db.INTERVIEW_STATUS status        " +
                "ON status.STATUS_ID = interviews.STATUS_ID        " +
                "WHERE interviews.USER_ID = :userId";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("userId", userId);

        return jdbcTemplate.queryForObject(sqlSelect, namedParameters, new JdbcInterviewDAO.InterviewMapper());

    }

    class InterviewMapper implements RowMapper<Interview> {
        @Override
        public Interview mapRow(ResultSet rs, int rowNum) throws SQLException {
            Interview interview = new Interview();
            interview.setId(rs.getInt("ID"));
            interview.setInterviewStartDate(rs.getDate("START_DATE"));
            interview.setInterviewStatus(rs.getString("STATUS_DE"));
            return interview;
        }
    }


}

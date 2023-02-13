package com.ncaoduc.SpringSecurityAndRestAPI.models.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ncaoduc.SpringSecurityAndRestAPI.models.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int row) throws SQLException {
        User userDetails = new User();
        userDetails.setUsername(rs.getString("username"));
        userDetails.setUsername(rs.getString("username"));
        userDetails.setPhoneNumber(rs.getString("phone_number"));
        return userDetails;
    }

}

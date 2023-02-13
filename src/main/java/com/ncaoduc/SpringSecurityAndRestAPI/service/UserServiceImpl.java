package com.ncaoduc.SpringSecurityAndRestAPI.service;

import com.ncaoduc.SpringSecurityAndRestAPI.models.User;
import com.ncaoduc.SpringSecurityAndRestAPI.models.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUser() {
        String sql = "SELECT * FROM users FULL OUTER JOIN authorities ON users.username = authorities.username";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
}

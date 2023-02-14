package com.ncaoduc.SpringSecurityAndRestAPI.service;

import com.ncaoduc.SpringSecurityAndRestAPI.models.User;
import com.ncaoduc.SpringSecurityAndRestAPI.models.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

    @Override
    public User addEmployee(String username, String password, String phoneNumber) {
        String sqlUser = "INSERT INTO users(username, password, phone_number, enabled) values (?, ?, ?, ?)";
        String sqlROLE = "INSERT INTO authorities(username, authority) values (? ,?)";
        jdbcTemplate.update(sqlUser, username, BCrypt.hashpw(password, BCrypt.gensalt(12)), phoneNumber, 1);
        jdbcTemplate.update(sqlROLE, username, "ROLE_EMPLOYEE");
        return new User(username, password, phoneNumber, "ROLE_EMPLOYEE", 1);
    }

    @Override
    public User deleteEmployee(String username) {

        String sqlUser = "DELETE FROM users WHERE username = ?;";
        String sqlROLE = "DELETE FROM authorities WHERE username = ?;";
        jdbcTemplate.update(sqlROLE, username);
        jdbcTemplate.update(sqlUser, username);

        return null;
    }

    @Override
    public User updateEmployee(String password, String phoneNumber, String username) {

        String sqlUser = "UPDATE users SET password = ?, phone_number = ?, enabled = ? WHERE username = ?;";
        String sqlROLE = "UPDATE authorities SET username = ?, authority = ? WHERE username = ?;";

        jdbcTemplate.update(sqlUser, BCrypt.hashpw(password, BCrypt.gensalt(12)), phoneNumber, 1, username);

        return new User(username, password, phoneNumber, "ROLE_EMPLOYEE", 1);
    }

}

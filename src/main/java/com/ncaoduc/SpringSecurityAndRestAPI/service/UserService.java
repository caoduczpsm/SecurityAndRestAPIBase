package com.ncaoduc.SpringSecurityAndRestAPI.service;

import com.ncaoduc.SpringSecurityAndRestAPI.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getUser();

    User addEmployee(String username, String password, String phoneNumber);

    User deleteEmployee(String username);

    User updateEmployee(String password, String phone_number, String username);

}

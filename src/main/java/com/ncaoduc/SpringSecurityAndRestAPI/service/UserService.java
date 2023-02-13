package com.ncaoduc.SpringSecurityAndRestAPI.service;

import com.ncaoduc.SpringSecurityAndRestAPI.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getUser();

}

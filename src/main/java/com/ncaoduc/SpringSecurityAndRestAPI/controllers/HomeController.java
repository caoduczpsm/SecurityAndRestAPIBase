package com.ncaoduc.SpringSecurityAndRestAPI.controllers;

import com.ncaoduc.SpringSecurityAndRestAPI.models.User;
import com.ncaoduc.SpringSecurityAndRestAPI.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}

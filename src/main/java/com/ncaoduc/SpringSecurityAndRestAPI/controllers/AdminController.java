package com.ncaoduc.SpringSecurityAndRestAPI.controllers;

import com.ncaoduc.SpringSecurityAndRestAPI.models.User;
import com.ncaoduc.SpringSecurityAndRestAPI.service.UserServiceImpl;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("index")
    public ModelAndView index(Model model){
        return new ModelAndView("admin/index");
    }

    @GetMapping("addition_employee_form")
    public ModelAndView showAddEmployForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("admin/addition_employee_form");
    }

    @PostMapping("addition_employee_successful")
    public ModelAndView addEmployee(@ModelAttribute("user") User user){
        userService.addEmployee(user.getUsername(), user.getPassword(), user.getPhoneNumber());
        return new ModelAndView("admin/addition_employee_successful");
    }

    @GetMapping("deleting_employee_form")
    public ModelAndView showDeleteEmployeeForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("admin/deleting_employee_form");
    }

    @DeleteMapping("/{username}")
    public ModelAndView deleteEmployee(@ModelAttribute("user") User user, @PathVariable String username){
        userService.deleteEmployee(user.getUsername());
        return new ModelAndView("admin/addition_employee_successful");
    }

    @GetMapping("update_employee_form")
    public ModelAndView showUpdateEmployeeForm(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return new ModelAndView("admin/update_employee_form");
    }

    @PutMapping("/{username}")
    public ModelAndView updateEmployee(@ModelAttribute("user") User user, @PathVariable String username){
        userService.updateEmployee(user.getPassword(), user.getPhoneNumber(), user.getUsername());
        return new ModelAndView("admin/addition_employee_successful");
    }

}
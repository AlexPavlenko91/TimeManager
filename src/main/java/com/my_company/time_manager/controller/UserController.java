package com.my_company.time_manager.controller;

import com.my_company.time_manager.model.Admin;
import com.my_company.time_manager.model.User;
import com.my_company.time_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
    @RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
    List<User> users = new ArrayList<>();
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public String getUser(Model model){
        model.addAttribute("user", userService.loadUserByUsername("1111"));
        model.addAttribute("users", userService.showAll());
        return "show_users";
    }

    @GetMapping(value = "/new_get")
    public String newStudent() {
        return "user_reg";
    }

    @PostMapping(value = "/new_post")
    public String newPostStudent(@ModelAttribute User user) {
        userService.save(user);
        return "/user_account";//вызов другого контроллера
    }
}

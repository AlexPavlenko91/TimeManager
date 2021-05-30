package com.my_company.time_manager.controller;

import com.my_company.time_manager.model.Admin;
import com.my_company.time_manager.service.AdminService;
import com.my_company.time_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
public class AdminController {
    List<Admin> admins = new ArrayList<>();
    private AdminService adminService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    /*@PostMapping(value = "/new_post"){
        public String newPostAdmin(@ModelAttribute Admin admin) {
            //students.add(student);
            adminService.save(admin);
            return "/show_users";//вызов другого контроллера
        }
    }*/
    @GetMapping(value = "/new_get")
    public String newStudent() {
        return "admin_reg";
    }

    @PostMapping(value = "/new_post")
    public String newPostStudent(@ModelAttribute Admin admin) {
        //students.add(student);
        adminService.save(admin);
        return "/show_users";//вызов другого контроллера
    }

    @PostMapping("")
    public String showUsers(Model model){
       // model.addAttribute("admin", adminService.loadUserByUsername("admin"));
        model.addAttribute("users", userService.showAll());
        return "show_users";
    }
}

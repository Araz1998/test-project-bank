package com.badalovaraz.testProjectBank.testprojectbank.controller;

import com.badalovaraz.testProjectBank.testprojectbank.business.service.UserService;
import com.badalovaraz.testProjectBank.testprojectbank.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class Main {

    private final UserService userService;

    @Autowired
    public Main(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getMain(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }
}

package com.badalovaraz.testProjectBank.testprojectbank.controller;

import com.badalovaraz.testProjectBank.testprojectbank.data.entity.User;
import com.badalovaraz.testProjectBank.testprojectbank.data.repository.UserRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.HashSet;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if(userFromDB != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setRoles(Sets.newHashSet());
        userRepository.save(user);
        return "redirect:/hello";
    }

}

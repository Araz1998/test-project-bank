package com.badalovaraz.testProjectBank.testprojectbank.controller;

import com.badalovaraz.testProjectBank.testprojectbank.data.entity.User;
import com.badalovaraz.testProjectBank.testprojectbank.data.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final UserRepo userRepo;

    @Autowired
    public RegistrationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if(userFromDB != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setRole("USER");
        userRepo.save(user);
        return "redirect:/hello";
    }

}

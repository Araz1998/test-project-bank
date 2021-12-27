package com.badalovaraz.testProjectBank.testprojectbank.controller;

import com.badalovaraz.testProjectBank.testprojectbank.data.entity.User;
import com.badalovaraz.testProjectBank.testprojectbank.data.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getHello() {
        return "user_page";
    }

    @PostMapping("user/transfer")
    public String transfer(User user, Map<String, Object> model) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if(userFromDB == null) {
            model.put("message", "User doesn't exist!");
            return "user_page";
        }
        System.out.println("GOOOOD");
        return "redirect:/hello";
    }
}

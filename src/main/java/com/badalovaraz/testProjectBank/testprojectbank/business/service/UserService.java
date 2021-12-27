package com.badalovaraz.testProjectBank.testprojectbank.business.service;

import com.badalovaraz.testProjectBank.testprojectbank.data.entity.User;
import com.badalovaraz.testProjectBank.testprojectbank.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        Iterable<User> users = this.userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(user -> {userList.add(user);});
        return userList;
    }
}

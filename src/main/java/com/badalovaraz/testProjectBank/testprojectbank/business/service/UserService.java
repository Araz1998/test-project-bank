package com.badalovaraz.testProjectBank.testprojectbank.business.service;

import com.badalovaraz.testProjectBank.testprojectbank.business.domain.UserPOJO;
import com.badalovaraz.testProjectBank.testprojectbank.data.entity.User;
import com.badalovaraz.testProjectBank.testprojectbank.data.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        Iterable<User> users = this.userRepo.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(user -> {userList.add(user);});
        return userList;
    }
}

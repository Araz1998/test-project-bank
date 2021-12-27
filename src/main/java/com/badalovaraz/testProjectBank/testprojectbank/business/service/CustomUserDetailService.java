package com.badalovaraz.testProjectBank.testprojectbank.business.service;

import com.badalovaraz.testProjectBank.testprojectbank.confiq.CustomUserDetails;
import com.badalovaraz.testProjectBank.testprojectbank.data.entity.User;
import com.badalovaraz.testProjectBank.testprojectbank.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user: " + username);
        }
        return new CustomUserDetails(user);
    }
}

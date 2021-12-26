package com.badalovaraz.testProjectBank.testprojectbank.data.repository;

import com.badalovaraz.testProjectBank.testprojectbank.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

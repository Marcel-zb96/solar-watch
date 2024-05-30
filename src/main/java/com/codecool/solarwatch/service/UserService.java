package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.entity.UserEntity;
import com.codecool.solarwatch.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserEntity user) {
        System.out.println(user);
        if (userRepository.getUserEntityByUsername(user.getUsername()).isEmpty()) {
            System.out.println("User not found");
            userRepository.save(user);
        } else {
            
            throw new IllegalArgumentException("User already exists");
        }
    }

}

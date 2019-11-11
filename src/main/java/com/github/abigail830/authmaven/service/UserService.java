package com.github.abigail830.authmaven.service;

import com.github.abigail830.authmaven.domain.User;
import com.github.abigail830.authmaven.infrastructure.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepositoryImpl userRepository;

    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
}

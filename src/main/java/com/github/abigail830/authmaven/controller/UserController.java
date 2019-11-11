package com.github.abigail830.authmaven.controller;

import com.github.abigail830.authmaven.domain.User;
import com.github.abigail830.authmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> login(){
        return userService.getAllUser();
    }
}

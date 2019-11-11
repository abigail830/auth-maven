package com.github.abigail830.authmaven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-admin")
    public String adminHelloWorld(){
        return "Hello World Admin";
    }


}

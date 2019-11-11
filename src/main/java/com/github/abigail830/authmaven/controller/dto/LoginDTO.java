package com.github.abigail830.authmaven.controller.dto;

import com.github.abigail830.authmaven.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {

    String userName;
    String password;

    public User toUser(){
        return new User(userName, password);
    }
}

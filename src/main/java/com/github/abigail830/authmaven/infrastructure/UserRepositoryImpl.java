package com.github.abigail830.authmaven.infrastructure;

import com.github.abigail830.authmaven.domain.User;
import com.github.abigail830.authmaven.infrastructure.entity.RoleEntity;
import com.github.abigail830.authmaven.infrastructure.entity.UserEntity;
import com.github.abigail830.authmaven.infrastructure.mapper.RoleMapper;
import com.github.abigail830.authmaven.infrastructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;


    public UserEntity getUserByName(String userName){
        return userMapper.loadUserByUsername(userName);
    }

    public List<RoleEntity> getRoleByUserId(Long id){
        return roleMapper.getRolesByUserId(id);
    }

    public List<User> getAllUser(){
        return userMapper.getAllUserEntity().stream()
                .map(UserEntity::toUser)
                .collect(Collectors.toList());
    }


}

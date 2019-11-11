package com.github.abigail830.authmaven.service;

import com.github.abigail830.authmaven.infrastructure.UserRepositoryImpl;
import com.github.abigail830.authmaven.infrastructure.entity.RoleEntity;
import com.github.abigail830.authmaven.infrastructure.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserRepositoryImpl userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final UserEntity userEntityByName = userRepository.getUserByName(userName);
        if(userEntityByName == null){
            log.warn( "UserEntity name not found");
            throw new UsernameNotFoundException("UserEntity name not found");
        }else{
            final List<RoleEntity> roleByUserId = userRepository.getRoleByUserId(userEntityByName.getId());
            userEntityByName.setAuthorities(roleByUserId);
        }
        log.info("UserEntity found : {}", userEntityByName);
        return userEntityByName;
    }
}

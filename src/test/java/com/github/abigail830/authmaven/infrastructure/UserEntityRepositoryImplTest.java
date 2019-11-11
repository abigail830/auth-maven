package com.github.abigail830.authmaven.infrastructure;

import com.github.abigail830.authmaven.infrastructure.entity.RoleEntity;
import com.github.abigail830.authmaven.infrastructure.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserEntityRepositoryImplTest {

    @Autowired
    UserRepositoryImpl userRepository;

    @Test
    void getUserByName() {

        final UserEntity userEntity = userRepository.getUserByName("userEntity");
        assertEquals("e10adc3949ba59abbe56e057f20f883e", userEntity.getPassword());
        assertEquals(1L, userEntity.getId());
    }

    @Test
    void getRoleByUserId() {

        final List<RoleEntity> roleEntityByUserId = userRepository.getRoleByUserId(1L);
        assertEquals(1, roleEntityByUserId.size());
        assertEquals("USER", roleEntityByUserId.get(0).getName());
    }
}
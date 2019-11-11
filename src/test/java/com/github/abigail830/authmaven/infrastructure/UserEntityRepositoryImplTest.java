package com.github.abigail830.authmaven.infrastructure;

import com.github.abigail830.authmaven.infrastructure.entity.RoleEntity;
import com.github.abigail830.authmaven.infrastructure.entity.UserEntity;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DBRider
class UserEntityRepositoryImplTest {

    @Autowired
    UserRepositoryImpl userRepository;

    @Test
    @DataSet(value = "userEntityRepoTest.yml", cleanBefore = true)
    void getUserByName() {
        final UserEntity userEntity = userRepository.getUserByName("user");
        assertEquals("password1", userEntity.getPassword());
        assertEquals(1L, userEntity.getId());
    }

    @Test
    @DataSet(value = "userEntityRepoTest.yml", cleanBefore = true)
    void getRoleByUserId() {
        final List<RoleEntity> roleEntityByUserId = userRepository.getRoleByUserId(1L);
        assertEquals(1, roleEntityByUserId.size());
        assertEquals("ROLE_USER", roleEntityByUserId.get(0).getName());
    }
}
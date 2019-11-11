package com.github.abigail830.authmaven.infrastructure.mapper;

import com.github.abigail830.authmaven.infrastructure.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE USER_NAME = '${userName,jdbcType=VARCHAR}'")
    UserEntity loadUserByUsername(String userName);

    @Select("SELECT * FROM USER")
    List<UserEntity> getAllUserEntity();
}

package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    User queryUserById(Integer userId);

    int addUser(User user);

    List<User> queryUserList();

    int deleteUserById(Integer userId);

    int updateUserById(Integer userId);

}

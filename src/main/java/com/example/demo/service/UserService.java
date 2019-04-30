package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface UserService {

    User queryUserById(Integer userId);

    int addUser(User user);

    List<User> queryUserList();

    int deleteUserById(Integer userId);

    int updateUserById(Integer userId);
}

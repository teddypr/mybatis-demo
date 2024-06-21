package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * ユーザーに関する業務処理を行うサービスクラス
 */
@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User insert(String name, String email) {
        User user = new User(null, name, email);
        userMapper.insert(user);
        return user;
    }


}

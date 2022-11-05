package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.UserMapper;
import com.example.codesystem.model.User;
import com.example.codesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cc
 * @date 2022年11月01日 21:40
 */
@Service
public class UseServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.selectByNameAndPwd(user);
    }

    @Override
    public int resgisterNameIsnull(User user) {
        return userMapper.selectIsname(user);
    }

    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }

    @Override
    public String selectPasswordByname(User user) {
        return userMapper.selectPasswordByname(user);
    }

    @Override
    public User selectByNameAndPwd(User user) {
        return userMapper.selectByNameAndPwd(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }
}

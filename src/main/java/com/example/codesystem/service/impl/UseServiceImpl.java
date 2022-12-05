package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.UserMapper;
import com.example.codesystem.model.User;
import com.example.codesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public int logout(User user) {
        return userMapper.selectStatus(user);
    }


    @Override
    public int resgisterNameIsnull(String userName) {
        return userMapper.selectIsname(userName);
    }

    @Override
    public int insert(String userName, String password, String email) {
       return userMapper.insert(userName, password, email);

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

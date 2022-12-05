package com.example.codesystem.service;


import com.example.codesystem.model.User;

import java.util.Date;

public interface UserService {
    User login(User user);//登录
    int logout(User user);//退出



    int resgisterNameIsnull(String userName);

    int insert(String userName, String password, String email);//注册用户
    String selectPasswordByname(User user);//通过用户名查找密码


    User selectByNameAndPwd(User user);//通过名字和密码查找用户
    int update(User user);//更新用户




}

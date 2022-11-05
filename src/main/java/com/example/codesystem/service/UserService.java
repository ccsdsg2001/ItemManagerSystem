package com.example.codesystem.service;


import com.example.codesystem.model.User;

public interface UserService {
    User login(User user);//登录


    int resgisterNameIsnull(User user);//检查用户名是否存在
    int register(User user);//注册

    String selectPasswordByname(User user);//通过用户名查找密码


    User selectByNameAndPwd(User user);//通过名字和密码查找用户
    int update(User user);//更新用户




}

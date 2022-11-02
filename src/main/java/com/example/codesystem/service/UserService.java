package com.example.codesystem.service;


import com.example.codesystem.model.User;

public interface UserService {
    public User login(User user);//登录


    public int resgisterNameIsnull(User user);//检查用户名是否存在
    public int register(User user);//注册

    public String selectPasswordByname(User user);//通过用户名查找密码




}

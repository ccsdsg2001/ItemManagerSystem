package com.example.codesystem.service;


import com.example.codesystem.model.User;

public interface UserService {
    public User login(User user);

    public int register(User user);


}

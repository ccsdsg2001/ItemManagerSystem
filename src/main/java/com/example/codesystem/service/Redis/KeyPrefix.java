package com.example.codesystem.service.Redis;

public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}

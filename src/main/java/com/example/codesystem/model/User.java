package com.example.codesystem.model;

import lombok.*;

import java.util.Date;

/**
 * @author cc
 * @date 2022年10月30日 20:36
 */
@Data
public class User extends BaseObject {
    private int id;
    private String userName;
    private String password;
    private String realName;
    private String  business;
    private String email;
    private String headPicture;
    private Date addDate;
    private Date updateDate;
    private int state;



}

package com.example.codesystem.model;

import lombok.Data;

import java.util.Date;

/**
 * @author cc
 * @date 2022年10月30日 20:52
 */
@Data
public class ReItem extends BaseObject{
    private int id;
    private String title;
    private String sellPoint;
    private int price;
    private int num;
    private String barcode;
    private String image;
    private int cid;
    private int status;
    private Date recovered;
    private String recoveredStr;
}


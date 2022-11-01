package com.example.codesystem.model;

import lombok.Data;

import java.util.Date;

/**
 * @author cc
 * @date 2022年10月30日 20:52
 */
@Data
public class ReItem {
    private Integer id;
    private String title;
    private String sellPoint;
    private Integer price;
    private Integer num;
    private Integer barcode;
    private String image;
    private Integer cid;
    private Integer status;
    private Date recovered;
}

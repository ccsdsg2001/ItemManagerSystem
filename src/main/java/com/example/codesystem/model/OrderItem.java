package com.example.codesystem.model;

import lombok.Data;

/**
 * @author cc
 * @date 2022年10月30日 20:46
 */
@Data
public class OrderItem {
    private Integer id;
    private Integer itemId;
    private Integer orderId;
    private Integer num;
    private String title;
    private Integer price;
    private Integer totleFee;
    private String picPath;



}

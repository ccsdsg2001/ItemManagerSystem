package com.example.codesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author cc
 * @date 2022年10月30日 20:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private Double payment;
    private Integer paymentType;
    private Integer postFee;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Date paymentTime;
    private Date consignTime;
    private Date endTime;
    private Date closeTime;
    private String shippingName;
    private String shippingCode;
    private Integer userId;
    private String buyerMessage;
    private String buyerNick;
    private Integer buyerRate;
    private Integer refundStatus;
    private String refundReadson;
    private Integer isRefund;




}

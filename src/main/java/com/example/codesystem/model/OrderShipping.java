package com.example.codesystem.model;

import lombok.*;

import java.util.Date;

/**
 * @author cc
 * @date 2022年11月12日 20:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderShipping {

    private String orderId;
    private String receiverName;
    private String receiverPhone;
    private String receiverMobile;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverZip;
    private Date created;
    private String createdStr;
    private String updatedStr;
    private Date updated;


}

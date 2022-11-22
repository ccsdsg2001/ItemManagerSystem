package com.example.codesystem.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

/**
 * @author cc
 * @date 2022年10月30日 20:46
 */
@Data
@Getter
@Setter
public class OrderItem extends BaseObject{
    private String id;

    private String itemId;

    private String orderId;

    private Integer num;

    private String title;

    private Long price;

    private Long totalFee;

    private String picPath;



}

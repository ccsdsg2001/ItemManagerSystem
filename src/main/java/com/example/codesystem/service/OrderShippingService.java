package com.example.codesystem.service;

import com.example.codesystem.model.OrderShipping;

import java.util.List;

public interface OrderShippingService {

    List<OrderShipping> selectAll();//显示发货管理的数据
    int deleteByPrimaryKey(String orderId);//删除
    int updateByPrimaryKey(OrderShipping record);
    OrderShipping selectByPrimaryKey(String orderId);
    int insert(OrderShipping record);
}

package com.example.codesystem.service;

import com.example.codesystem.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    int deleteByPrimaryKey(String id);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(String id);

    OrderItem selectByPrimaryOrderKey(String orderId);

    List<OrderItem> selectAll();

    int updateByPrimaryKey(OrderItem record);
}

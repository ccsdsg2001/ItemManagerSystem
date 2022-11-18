package com.example.codesystem.service;

import com.example.codesystem.model.Delivery;

import java.util.List;

public interface DeliveryService {
    int deleteByPrimaryKey(Integer id);
    int deleteByDeliveryName(String deliveryName);

    int insert(Delivery record);

    Delivery selectByPrimaryKey(Integer id);

    List<Delivery> selectAll();

    int updateByPrimaryKey(Delivery record);

    Delivery selectByName(String name);
}

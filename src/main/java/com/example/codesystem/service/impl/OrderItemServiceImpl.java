package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.OrderItemMapper;
import com.example.codesystem.model.OrderItem;
import com.example.codesystem.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月22日 22:22
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {


    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderItem record) {
        return orderItemMapper.insert(record);
    }

    @Override
    public OrderItem selectByPrimaryKey(String id) {
        return orderItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public OrderItem selectByPrimaryOrderKey(String orderId) {
        return orderItemMapper.selectByPrimaryOrderKey(orderId);
    }

    @Override
    public List<OrderItem> selectAll() {
        return orderItemMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(OrderItem record) {
        return orderItemMapper.updateByPrimaryKey(record);
    }
}

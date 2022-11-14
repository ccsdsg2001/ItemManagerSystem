package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.OrderShippingMapper;
import com.example.codesystem.model.OrderShipping;
import com.example.codesystem.service.OrderShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月14日 22:34
 */
@Service
public class OrderShippingImpl implements OrderShippingService {

    @Autowired
    OrderShippingMapper orderShippingMapper;

    @Override
    public List<OrderShipping> selectAll() {
        return orderShippingMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderShippingMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKey(OrderShipping record) {
        return orderShippingMapper.updateByPrimaryKey(record);
    }

    @Override
    public OrderShipping selectByPrimaryKey(String orderId) {
        return orderShippingMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int insert(OrderShipping record) {
        return orderShippingMapper.insert(record);
    }
}

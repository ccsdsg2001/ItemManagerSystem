package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.OrderShippingMapper;
import com.example.codesystem.model.Order;
import com.example.codesystem.model.OrderShipping;
import com.example.codesystem.service.OrderShippingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月14日 22:34
 */
@Service
@Slf4j
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

    @Override
    public List<OrderShipping> searchByname(String name) {
        return orderShippingMapper.searchByName(name);
    }


    @Override
    public PageInfo<OrderShipping> findAllByPage(Integer pageNum, Integer pageSize) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);
        List<OrderShipping> orderShippings = orderShippingMapper.selectAll();
        PageInfo<OrderShipping> pageInfo = new PageInfo<>(orderShippings);
        return pageInfo;

    }

    @Override
    public PageInfo<OrderShipping> searchByname(Integer pageNum, Integer pageSize, String name) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);
        List<OrderShipping> orderShippings = orderShippingMapper.searchByName(name);
        PageInfo<OrderShipping> pageInfo = new PageInfo<>(orderShippings);
        return pageInfo;
    }
}

package com.example.codesystem.service;

import com.example.codesystem.model.Order;
import com.example.codesystem.model.OrderShipping;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderShippingService {

    List<OrderShipping> selectAll();//显示发货管理的数据
    int deleteByPrimaryKey(String orderId);//删除
    int updateByPrimaryKey(OrderShipping record);
    OrderShipping selectByPrimaryKey(String orderId);
    int insert(OrderShipping record);

    List<OrderShipping> searchByname(String name);

    PageInfo<OrderShipping> findAllByPage(Integer pageNum, Integer pageSize);
    PageInfo<OrderShipping> searchByname(Integer pageNum, Integer pageSize,String name);

}

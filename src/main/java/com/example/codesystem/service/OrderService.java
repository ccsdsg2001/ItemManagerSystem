package com.example.codesystem.service;

import com.example.codesystem.model.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    Order selectByPrimaryKey(String orderId);

    List<Order> list(Order order);

    List<Order> listRefund(Order order);

    List<Order> selectAll();

    Integer selectCurOrderNum();
    Integer selectLastOrderNum();

    Long selectCurPayment();
    Long selectLastPayment();

    Integer selectCurRefundOrder();
    Integer selectLastRefundOrder();

    Integer selectDayOrderSum(Order order);
    Integer selectDayOrderNum(Order order);

    Integer updateByPrimaryKey(Order record);

    PageInfo<Order> findByPage(Integer pageNum, Integer pageSize);

    PageInfo<Order> findByPagebyrefund(Integer pageNum, Integer pageSize, Order order);

    PageInfo<Order> searchByrefundStatusStr(Integer pageNum, Integer pageSize,String refundStatusStr);

    PageInfo<Order> listByPaymentTypeAndStatus(Integer pageNum,Integer pageSize,Integer paymenType,Integer status);


}

package com.example.codesystem.mapper;

import com.example.codesystem.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    Order selectByPrimaryKey(String orderId);

    List<Order> list(Order order);

    List<Order> listRefund(Order order);

    List<Order> selectAll();

    List<Order> searchByRefundStatusStr(@Param("refundStatusStr") String refundStatusStr);

    Integer selectCurOrderNum();
    Integer selectLastOrderNum();

    Long selectCurPayment();
    Long selectLastPayment();

    Integer selectCurRefundOrder();
    Integer selectLastRefundOrder();

    Integer selectDayOrderSum(Order order);
    Integer selectDayOrderNum(Order order);

    Integer updateByPrimaryKey(Order record);

    List<Order> listByPaymentTypeAndStatus(Integer paymentType,Integer status);
}

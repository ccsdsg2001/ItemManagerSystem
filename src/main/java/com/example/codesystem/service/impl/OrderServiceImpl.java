package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.OrderItemMapper;
import com.example.codesystem.mapper.OrderMapper;
import com.example.codesystem.model.Order;
import com.example.codesystem.model.OrderItem;
import com.example.codesystem.service.OrderService;
import com.example.codesystem.util.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cc
 * @date 2022年11月22日 21:52
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


//    @Autowired
//    @Resource
    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public Order selectByPrimaryKey(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<Order> list(Order order) {
        return orderMapper.list(order);
    }

    @Override
    public List<Order> listRefund(Order order) {
        return orderMapper.listRefund(order);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public Integer selectCurOrderNum() {
        return orderMapper.selectCurOrderNum();
    }

    @Override
    public Integer selectLastOrderNum() {
        return orderMapper.selectLastOrderNum();
    }

    @Override
    public Long selectCurPayment() {
        return orderMapper.selectCurPayment();
    }

    @Override
    public Long selectLastPayment() {
        return orderMapper.selectLastPayment();
    }

    @Override
    public Integer selectCurRefundOrder() {
        return orderMapper.selectCurRefundOrder();
    }

    @Override
    public Integer selectLastRefundOrder() {
        return orderMapper.selectLastRefundOrder();
    }

    @Override
    public Integer selectDayOrderSum(Order order) {
        return orderMapper.selectDayOrderSum(order);
    }

    @Override
    public Integer selectDayOrderNum(Order order) {
        return orderMapper.selectDayOrderNum(order);
    }

    @Override
    public Integer updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Order> findByPage(Integer pageNum, Integer pageSize) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);


        List<Order> reItems = orderMapper.selectAll();
        PageInfo<Order> pageInfo = new PageInfo<>(reItems);
        return pageInfo;

    }


    @Override
    public PageInfo<Order> findByPagebyrefund(Integer pageNum, Integer pageSize, Order order) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);


        List<Order> orderList = orderMapper.selectAll();

//        for (Order order1 : orderList) {
//            String orderId = order1.getOrderId();
//            if (orderItemMapper.selectByPrimaryOrderKey(orderId) != null) {
//                OrderItem orderItem = orderItemMapper.selectByPrimaryOrderKey(orderId);
//                order1.setItemTitle(orderItem.getTitle());
//                order1.setTotalFee(orderItem.getTotalFee());
//                order1.setNum(orderItem.getNum());
//                order1.setStatusStr(getStatusStrById(order1.getStatus()));
//                order1.setDateStr1(DateUtil.getDateStr(order1.getCreateTime()));
//                order1.setPaymentTypeStr(getPaymentTypeById(order1.getPaymentType()));
//                order1.setRefundStatusStr(getRefundStatusStr(order1.getRefundStatus()));
//            }
//        }



        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        return pageInfo;

    }

    @Override
    public PageInfo<Order> searchByrefundStatusStr(Integer pageNum, Integer pageSize, String refundStatusStr) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);
        List<Order> orderList = orderMapper.searchByRefundStatusStr(refundStatusStr);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        return pageInfo;
    }


    public String getPaymentTypeById(int i) {
        switch (i) {
            case 1:
                return "在线支付";
            case 2:
                return "货到付款";
        }
        return null;
    }

    public String getStatusStrById(int i) {
        switch (i) {
            case 1:
                return "未付款";
            case 2:
                return "已付款";
            case 3:
                return "未发货";
            case 4:
                return "已发货";
            case 5:
                return "交易成功";
            case 6:
                return "交易关闭";
        }
        return null;
    }

    public String getbuyerRateStrById(int i) {
        switch (i) {
            case 0:
                return "否";
            case 1:
                return "是";
        }
        return null;
    }

    public String getRefundStatusStr(int i) {
        switch (i) {
            case 1:
                return "申请退款";
            case 2:
                return "退款失败";
            case 3:
                return "退款成功";
        }
        return null;
    }

}

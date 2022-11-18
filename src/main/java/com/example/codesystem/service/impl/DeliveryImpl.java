package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.DeliveryMapper;
import com.example.codesystem.model.Delivery;
import com.example.codesystem.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月18日 21:19
 */
@Service
public class DeliveryImpl implements DeliveryService {
    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return deliveryMapper.deleteByPrimaryKey(id) ;
    }

    @Override
    public int deleteByDeliveryName(String deliveryName) {
        return deliveryMapper.deleteByDeliveryName(deliveryName);
    }

    @Override
    public int insert(Delivery record) {
        return deliveryMapper.insert(record);
    }

    @Override
    public Delivery selectByPrimaryKey(Integer id) {
        return deliveryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Delivery> selectAll() {
        return deliveryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Delivery record) {
        return deliveryMapper.updateByPrimaryKey(record);
    }

    @Override
    public Delivery selectByName(String name) {
        return deliveryMapper.selectByName(name);
    }
}

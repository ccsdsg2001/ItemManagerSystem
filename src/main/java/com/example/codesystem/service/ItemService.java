package com.example.codesystem.service;

import com.example.codesystem.mapper.ItemMapper;
import com.example.codesystem.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ItemService {

    List<Item> list(Item item);//查询商品数据

    List<Item> lists(Item item);//查询商品所有数据

    List<Item> selectall();//查询所有


}

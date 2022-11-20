package com.example.codesystem.service;

import com.example.codesystem.mapper.ItemMapper;
import com.example.codesystem.model.Item;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ItemService {


    Item findById(Item item);

    void delete(Item item);

    List<Item> list(Item item);

    List<Item> listS(Item item);

//    int count(Item item);

    int insert(Item item);

    int update (Item item);


    List<Item> selectAll();


    PageInfo<Item> findByPage(Integer pageNum, Integer pageSize);
}

package com.example.codesystem.service;

import com.example.codesystem.mapper.ItemMapper;
import com.example.codesystem.model.Item;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ItemService {



    List<Item> findBytitle(String title);

    Item findById(Item item);

    void delete(Item item);

    List<Item> list(Item item);

    List<Item> listS(Item item);

    int count(Item item);

    int insert(Item item);

    int update (Item item);


    List<Item> selectAll();


    PageInfo<Item> findByPage(Integer pageNum, Integer pageSize);

    PageInfo<Item> findByPagetest(Integer pageNum, Integer pageSize, Item item);

    PageInfo<Item> findBytitle(Integer pageNum, Integer pageSize, String title);

    PageInfo<Item> findBysearch(Integer pageNum, Integer pageSize, String title,Integer cid);
}

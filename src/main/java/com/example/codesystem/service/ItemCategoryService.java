package com.example.codesystem.service;

import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.OrderShipping;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月16日 22:57
 */

public interface ItemCategoryService {

    ItemCategory findById(ItemCategory itemCategory);

    List<ItemCategory> list(ItemCategory itemCategory);

    List<ItemCategory> list1();

    int count(ItemCategory itemCategory);

    int insert(ItemCategory itemCategory);

    int update(ItemCategory itemCategory);

    void delete(ItemCategory itemCategory);


    List<ItemCategory> LISTByNAME(String name);

    int updateStatus(ItemCategory itemCategory);

    PageInfo<ItemCategory> findByPage(Integer pageNum, Integer pageSize);

    PageInfo<ItemCategory> ListByname(Integer pageNum, Integer pageSize,String name);
}

package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.ItemCategoryMapper;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月16日 22:59
 */
@Service
public class ItemCategoryImpl implements ItemCategoryService {

    @Autowired
    ItemCategoryMapper itemCategoryMapper;

    @Override
    public List<ItemCategory> listALL() {
        return itemCategoryMapper.list1();
    }



}

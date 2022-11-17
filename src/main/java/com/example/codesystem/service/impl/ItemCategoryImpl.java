package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.ItemCategoryMapper;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.service.ItemCategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月16日 22:59
 */
@Service
@Slf4j
public class ItemCategoryImpl implements ItemCategoryService {

    @Autowired
    ItemCategoryMapper itemCategoryMapper;


    @Override
    public ItemCategory findById(ItemCategory itemCategory) {
        return itemCategoryMapper.findById(itemCategory);
    }

    @Override
    public List<ItemCategory> list(ItemCategory itemCategory) {
        return itemCategoryMapper.list(itemCategory);
    }

    @Override
    public List<ItemCategory> list1() {
        return itemCategoryMapper.list1();
    }

    @Override
    public int count(ItemCategory itemCategory) {
        return itemCategoryMapper.count(itemCategory);
    }

    @Override
    public int insert(ItemCategory itemCategory) {
        return itemCategoryMapper.insert(itemCategory);
    }

    @Override
    public int update(ItemCategory itemCategory) {
        return itemCategoryMapper.update(itemCategory);
    }

    @Override
    public void delete(ItemCategory itemCategory) {
        itemCategoryMapper.delete(itemCategory);
    }

    @Override
    public int updateStatus(ItemCategory itemCategory) {
        return 0;
    }



    @Override
    public PageInfo<ItemCategory> findByPage(Integer pageNum, Integer pageSize) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);
        List<ItemCategory> list = itemCategoryMapper.list1();
        PageInfo<ItemCategory> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }



}

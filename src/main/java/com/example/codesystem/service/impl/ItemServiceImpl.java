package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.ItemMapper;
import com.example.codesystem.model.Item;
import com.example.codesystem.service.ItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月09日 23:17
 */
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<Item> findBytitle(String title) {
        return itemMapper.findByTitle(title);
    }

    @Override
    public Item findById(Item item) {
        return itemMapper.findById(item);
    }

    @Override
    public void delete(Item item) {

        itemMapper.delete(item);
    }

    @Override
    public List<Item> list(Item item) {
        return itemMapper.list(item);
    }

    @Override
    public List<Item> listS(Item item) {
        return itemMapper.listS(item);
    }

    @Override
    public int count(Item item) {
        return itemMapper.count(item);
    }

//    @Override
//    public int count(Item item) {
//        return itemMapper.count(item);
//    }

    @Override
    public int insert(Item item) {
        return itemMapper.insert(item);
    }

    @Override
    public int update(Item item) {
        return itemMapper.update(item);
    }

    @Override
    public List<Item> selectAll() {
        return itemMapper.selectAll();
    }


    @Override
    public PageInfo<Item> findByPage(Integer pageNum, Integer pageSize) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);
        List<Item> list = itemMapper.selectAll();

        PageInfo<Item> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }


    @Override
    public PageInfo<Item> findByPagetest(Integer pageNum, Integer pageSize,Item item) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);
        List<Item> list = itemMapper.list(item);

        PageInfo<Item> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }
    @Override
    public PageInfo<Item> findBytitle(Integer pageNum, Integer pageSize,String title) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);
        List<Item> byTitle = itemMapper.findByTitle(title);

        PageInfo<Item> pageInfo = new PageInfo<>(byTitle);
        return pageInfo;

    }

    @Override
    public PageInfo<Item> findBysearch(Integer pageNum, Integer pageSize, String title, Integer cid) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);
        List<Item> byTitle = itemMapper.searchByitem(title,cid);

        PageInfo<Item> pageInfo = new PageInfo<>(byTitle);
        return pageInfo;
    }


}

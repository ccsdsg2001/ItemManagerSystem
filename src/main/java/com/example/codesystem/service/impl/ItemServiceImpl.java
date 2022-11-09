package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.ItemMapper;
import com.example.codesystem.model.Item;
import com.example.codesystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月09日 23:17
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<Item> list(Item item) {
        return itemMapper.list(item);
    }

    @Override
    public List<Item> lists(Item item) {
        return itemMapper.listS(item);
    }

    @Override
    public List<Item> selectall() {
        return itemMapper.selectAll();
    }
}

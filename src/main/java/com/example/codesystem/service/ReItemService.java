package com.example.codesystem.service;


import com.example.codesystem.model.ReItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ReItemService {
    int deleteByPrimaryKey(int id);

    int insert(ReItem record);

    ReItem selectByPrimaryKey(int id);

    List<ReItem> selectAll();

    int updateByPrimaryKey(ReItem record);

    PageInfo<ReItem> findByPage(Integer pageNum, Integer pageSize);
}

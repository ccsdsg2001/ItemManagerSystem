package com.example.codesystem.service.impl;

import com.example.codesystem.mapper.ReItemMapper;
import com.example.codesystem.model.ReItem;
import com.example.codesystem.service.ReItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月22日 20:51
 */
@Service
@Slf4j
public class ReItemServiceImpl  implements ReItemService {

    @Autowired
    ReItemMapper reItemMapper;

    @Override
    public int deleteByPrimaryKey(int id) {
        return reItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ReItem record) {
        return reItemMapper.insert(record);
    }

    @Override
    public ReItem selectByPrimaryKey(int id) {
        return reItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ReItem> selectAll() {
        return reItemMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ReItem record) {
        return reItemMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<ReItem> findByPage(Integer pageNum, Integer pageSize) {
        log.info("pagenum:{}",pageNum);
        log.info("pagesize:{}",pageNum);
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        log.info("page:{}", objects);


        List<ReItem> reItems = reItemMapper.selectAll();
        PageInfo<ReItem> pageInfo = new PageInfo<>(reItems);
        return pageInfo;

    }
}

package com.example.codesystem.mapper;

import com.example.codesystem.model.ReItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReItemMapper {
    int deleteByPrimaryKey(int id);

    int insert(ReItem record);

    ReItem selectByPrimaryKey(int id);

    List<ReItem> selectAll();

    int updateByPrimaryKey(ReItem record);
}

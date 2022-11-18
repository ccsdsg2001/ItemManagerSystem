package com.example.codesystem.mapper;

import com.example.codesystem.model.Item;
import com.example.codesystem.model.ItemCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemCategoryMapper {

    ItemCategory findById(ItemCategory itemCategory);//通过Id查找物品

    List<ItemCategory> list(ItemCategory itemcategory);//根据物品查找

    List<ItemCategory> list1();//显示所有

    int count(ItemCategory itemCategory);

    int insert(ItemCategory itemCategory);

    int update(ItemCategory itemCategory);

    int delete(ItemCategory itemCategory);

    int updateStatus(ItemCategory itemCategory);

    List<ItemCategory> listByName(String name);


}

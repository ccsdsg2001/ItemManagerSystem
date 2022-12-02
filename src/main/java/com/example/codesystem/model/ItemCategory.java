package com.example.codesystem.model;

import lombok.*;

import java.util.Date;

/**
 * @author cc
 * @date 2022年11月09日 23:25
 */
@Data
public class ItemCategory extends BaseObject{
    private int id;
    private  int parentId;
    private String name;
    /**
     * 状态。可选值:1(正常),2(删除)
     */
    private int status;
    private int sortOrder;
    private int isParent;
    private Date created;
    private Date updated;
    private String createdStr;
    private String updatedStr;


}

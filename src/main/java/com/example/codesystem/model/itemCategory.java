package com.example.codesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author cc
 * @date 2022年11月09日 23:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class itemCategory {
    private Integer id;
    private   Integer parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Integer isParent;
    private Date created;
    private Date updated;
    private String createdStr;
    private String updatedStr;
}

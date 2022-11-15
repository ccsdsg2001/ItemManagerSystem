package com.example.codesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月15日 22:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResObject<T> {

    private String resCode;
    private String resMessage;
    private Object resObject;
    private List<T> resList;
}

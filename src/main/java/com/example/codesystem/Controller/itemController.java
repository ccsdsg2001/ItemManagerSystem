package com.example.codesystem.Controller;

import com.example.codesystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cc
 * @date 2022年11月07日 21:31
 */
@Controller
public class itemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/user/itemManage")
    public String itemManage(){
        return "item/itemManage";
    }
}

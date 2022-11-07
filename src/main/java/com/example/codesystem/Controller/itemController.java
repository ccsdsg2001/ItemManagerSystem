package com.example.codesystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cc
 * @date 2022年11月07日 21:31
 */
@Controller
public class itemController {

    @RequestMapping("/user/itemManage")
    public String itemManage(){
        return "item/itemManage";
    }
}

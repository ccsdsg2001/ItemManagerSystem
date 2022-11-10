package com.example.codesystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cc
 * @date 2022年11月10日 23:37
 */
@Controller
public class StockController {

    @RequestMapping("/user/stock")
    public String Stock(){
        return "item/stockManage";
    }
}

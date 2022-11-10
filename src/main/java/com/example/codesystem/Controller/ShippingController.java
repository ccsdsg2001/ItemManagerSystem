package com.example.codesystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cc
 * @date 2022年11月10日 23:38
 */
@Controller
public class ShippingController {

    @RequestMapping("/user/shippingManage")
    public String shipping(){
        return "order/shippingManage";
    }
}

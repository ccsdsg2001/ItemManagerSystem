package com.example.codesystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cc
 * @date 2022年11月04日 21:27
 */
@Controller
public class OrderController {
    @RequestMapping("/user/orderManage")
    public String orderManage(){
        return "order/orderManage";
    }

    @RequestMapping("/user/orderRefund")
    public String refund(){
        return "order/orderRefund";

    }
}

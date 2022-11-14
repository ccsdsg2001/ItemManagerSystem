package com.example.codesystem.Controller;

import com.example.codesystem.model.OrderShipping;
import com.example.codesystem.service.OrderShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月10日 23:38
 */
@Controller
public class ShippingController {

    @Autowired
    OrderShippingService orderShippingService;

    @RequestMapping("/user/shippingManage")
   public String shipping(Model model){
        List<OrderShipping> orderShippingList = orderShippingService.selectAll();
        model.addAttribute("orderShippingList",orderShippingList);
        return "order/shippingManage";
    }




}

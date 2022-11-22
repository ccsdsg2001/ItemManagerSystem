package com.example.codesystem.Controller;

import com.example.codesystem.model.Item;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.Order;
import com.example.codesystem.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cc
 * @date 2022年11月04日 21:27
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;


    @RequestMapping("/user/orderManage")
    public String orderManage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize, Model model, String name, Item item, Order order){

        PageInfo<Order> pageInfo = orderService.findByPage(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("order", order);

        return "order/orderManage";
    }

    @RequestMapping("/user/orderRefund")
    public String refund(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize, Model model,
                         String name, Item item, Order order){


        PageInfo<Order> byPagebyrefund = orderService.findByPagebyrefund(pageNum, pageSize, order);
        model.addAttribute("pageInfo",byPagebyrefund);
        model.addAttribute("order", order);
        return "order/orderRefund";

    }
}

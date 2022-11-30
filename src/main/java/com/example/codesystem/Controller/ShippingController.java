package com.example.codesystem.Controller;

import com.example.codesystem.model.Order;
import com.example.codesystem.model.OrderShipping;
import com.example.codesystem.model.ResObject;
import com.example.codesystem.service.OrderShippingService;
import com.example.codesystem.util.Constant;
import com.example.codesystem.util.DateUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月10日 23:38
 */
@Controller
public class ShippingController {

    @Autowired
    OrderShippingService orderShippingService;


    @PostMapping("/user/shippingManage?name=")
    public String shippingsearchbyname(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize,
                                       Model model, @PathVariable("name") String orderId , Order order){
        OrderShipping orderShipping = orderShippingService.selectByPrimaryKey(order.getOrderId());
        model.addAttribute("pageInfo",orderShipping);



        return "order/shippingManage";
    }


    @RequestMapping("/user/shippingManage")
   public String shipping(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                          @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize, Model model){
        PageInfo<OrderShipping> pageInfo = orderShippingService.findAllByPage(pageNum, pageSize);
        List<OrderShipping> list = pageInfo.getList();
        for (OrderShipping orderShipping1 : pageInfo.getList()){
            orderShipping1.setCreatedStr(DateUtil.getDateStr(orderShipping1.getCreated()));//创造时间 在发货管理显示
            orderShipping1.setUpdatedStr(DateUtil.getDateStr(orderShipping1.getUpdated()));//收货时间
        }

        model.addAttribute("pageInfo",pageInfo);
        return "order/shippingManage";
    }

    @ResponseBody
    @PostMapping("/user/shippingEditState")
    public ResObject<Object> shippingEditState(OrderShipping orderShipping){
        orderShippingService.deleteByPrimaryKey(orderShipping.getOrderId());
        ResObject<Object> object = new ResObject<Object>(Constant.Code01, Constant.Msg01, null, null);
        return object;
    }




}

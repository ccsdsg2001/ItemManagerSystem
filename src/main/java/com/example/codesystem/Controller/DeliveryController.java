package com.example.codesystem.Controller;

import com.example.codesystem.model.Delivery;
import com.example.codesystem.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月10日 23:38
 */
@Controller
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    private int id;

    @RequestMapping("/user/deliveryManage")
    public String Delivery(Model model, Delivery delivery){
        List<Delivery> list = deliveryService.selectAll();
        model.addAttribute("list", list);

        return "others/deliveryManage";
    }

    @GetMapping("/user/search")
    public String searchGet(Model model,Delivery delivery,Integer id){
         id = delivery.getId();
        Delivery delivery1 = deliveryService.selectByPrimaryKey(id);
        model.addAttribute("delivery", delivery1);
        return "others/search";
    }

    @GetMapping("user/deliveryEdit")
    public String deliveryEditGet(Model model, Delivery delivery){
        return "others/deliveryEdit";
    }

    @PostMapping("user/deliveryEdit")
    public String deli(Model model,Delivery delivery){
        deliveryService.insert(delivery);
        return "redirect:deliveryManage";
    }


    @RequestMapping("user/deliveryDeleteState")
    public String deliveryDeleteStatePost(Model model, Delivery delivery){
        deliveryService.deleteByDeliveryName(delivery.getDeliveryName());
        return "redirect:deliveryManage";
    }
}

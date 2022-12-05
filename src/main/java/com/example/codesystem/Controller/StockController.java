package com.example.codesystem.Controller;

import com.example.codesystem.model.Item;
import com.example.codesystem.service.ItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cc
 * @date 2022年11月10日 23:37
 */
@Controller
public class StockController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/user/stock")
    public String Stock(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "15")Integer pageSize, Model model, Item item){
        PageInfo<Item> itemList = itemService.findByPage(pageNum, pageSize);
        model.addAttribute("item",item);
        model.addAttribute("pageInfo", itemList);
        return "item/stockManage";
    }


    @RequestMapping("/user/searchBystockandtitle")
    public String searchBystockandtitle(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "15")Integer pageSize
                                        ,Model model,String title){
        PageInfo<Item> bytitle = itemService.findBytitle(pageNum, pageSize, title);
        model.addAttribute("pageInfo", bytitle);


        return "item/stockManage";
    }


}

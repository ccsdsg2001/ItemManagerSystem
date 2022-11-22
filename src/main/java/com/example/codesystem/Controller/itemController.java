package com.example.codesystem.Controller;

import com.example.codesystem.model.Item;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.service.ItemCategoryService;
import com.example.codesystem.service.ItemService;
import com.example.codesystem.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cc
 * @date 2022年11月07日 21:31
 */
@Controller
public class itemController {
    @Autowired
    ItemService itemService;


    @Autowired
    ItemCategoryService itemCategoryService;

    @RequestMapping("/user/itemManage")
    public String itemManage(ItemCategory itemCategory, @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize, Model model, String name, Item item){


        PageInfo<Item> byPage = itemService.findByPage(pageNum, pageSize);
        model.addAttribute("pageInfo",byPage);
        model.addAttribute("item", item);

        return "item/itemManage";
    }
}

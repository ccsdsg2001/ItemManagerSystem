package com.example.codesystem.Controller;

import com.example.codesystem.model.Item;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.ReItem;
import com.example.codesystem.model.ResObject;
import com.example.codesystem.service.ItemCategoryService;
import com.example.codesystem.service.ItemService;
import com.example.codesystem.service.ReItemService;
import com.example.codesystem.util.Constant;
import com.example.codesystem.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author cc
 * @date 2022年11月07日 21:31
 */
@Controller
public class itemController {
    @Autowired
    ItemService itemService;
    @Autowired
    ReItemService reItemService;


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

    @ResponseBody
    @PostMapping("/user/itemEditState")
    public ResObject<Object> itemEditState(Item item1) {
        Item item = itemService.findById(item1);
        ReItem reItem = new ReItem();
        reItem.setId(item.getId());
        reItem.setBarcode(item.getBarcode());
        reItem.setCid(item.getCid());
        reItem.setImage(item.getImage());
        reItem.setPrice(item.getPrice());
        reItem.setNum(item.getNum());
        reItem.setSellPoint(item.getSellPoint());
        reItem.setStatus(item.getStatus());
        reItem.setTitle(item.getTitle());
        reItem.setRecovered(new Date());
        reItemService.insert(reItem);
        itemService.delete(item1);
        ResObject<Object> object = new ResObject<Object>(Constant.Code01, Constant.Msg01, null, null);
        return object;

    }

    @GetMapping("/user/itemEdit")
    public String itemEdit(Model model,Item item){
        ItemCategory itemCategory = new ItemCategory();
        itemCategory.setStart(0);
        itemCategory.setEnd(Integer.MAX_VALUE);

        List<ItemCategory> list = itemCategoryService.list(itemCategory);
        model.addAttribute("itemCategoryList",list);
        if(item.getId()!=0){
            Item item1 = itemService.findById(item);
            String id =String.valueOf(item.getId());




        }

        return "item/itemEdit";
    }



}

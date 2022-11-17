package com.example.codesystem.Controller;

import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.ResObject;
import com.example.codesystem.service.ItemCategoryService;
import com.example.codesystem.util.Constant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author cc
 * @date 2022年11月10日 23:37
 */
@Controller
public class ItemCategoryController {

    @Autowired
    ItemCategoryService itemCategoryService;

    @RequestMapping("/user/itemCategory")
    public String itemCategory(ItemCategory itemCategory,@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize, Model model){


        PageInfo<ItemCategory> byPage = itemCategoryService.findByPage(pageNum, pageSize);
        model.addAttribute("pageInfo",byPage);
        model.addAttribute("itemCategory", itemCategory);
        return "item/itemCategoryManage";
    }

//    @RequestMapping("/deleteitem")
//    public String deleteitem(ItemCategory itemCategory){
//        itemCategoryService.delete(itemCategory);
//        return "item/itemCategoryManage";
//    }

    @PostMapping("/user/itemCategoryEdit")
    public String itemEdit(){
        return "";
    }



    @ResponseBody
    @PostMapping("/user/itemCategoryEditState")
    public ResObject<Object> itemCategoryEditState(ItemCategory itemCategory){
        itemCategoryService.delete(itemCategory);
        ResObject<Object> object = new ResObject<Object>(Constant.Code01, Constant.Msg01, null, null);
        return object;
    }

}

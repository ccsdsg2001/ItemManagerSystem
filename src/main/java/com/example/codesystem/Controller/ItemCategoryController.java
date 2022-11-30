package com.example.codesystem.Controller;

import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.ResObject;
import com.example.codesystem.service.ItemCategoryService;
import com.example.codesystem.util.Constant;
import com.example.codesystem.util.DateUtil;
import com.example.codesystem.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author cc
 * @date 2022年11月10日 23:37
 */
@Controller
public class ItemCategoryController {

    @Autowired
    ItemCategoryService itemCategoryService;



    @PostMapping ("/user/itemCategory")
    public String name( ItemCategory itemCategory,String name ,Model model){
         name = itemCategory.getName();
        List<ItemCategory> itemCategories = itemCategoryService.LISTByNAME(name);
        for (ItemCategory i : itemCategories){
            i.setCreatedStr(DateUtil.getDateStr(i.getCreated()));
        }
        model.addAttribute("pageInfo", itemCategories);
        return "item/itemCategoryManage";
    }

    @RequestMapping("/user/itemCategory")
    public String itemCategory(ItemCategory itemCategory,@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize, Model model, String name){


//        itemCategoryService.findById(name);

        PageInfo<ItemCategory> byPage = itemCategoryService.findByPage(pageNum, pageSize);
        for (ItemCategory i : byPage.getList()){
            i.setCreatedStr(DateUtil.getDateStr(i.getCreated()));
        }

        PageUtil.getPageContent("itemCategory?name="+itemCategory.getName(),pageNum , pageSize, PageInfo.DEFAULT_NAVIGATE_PAGES);
        model.addAttribute("pageInfo",byPage);
        model.addAttribute("itemCategory", itemCategory);
        return "item/itemCategoryManage";
    }

//    @RequestMapping("/deleteitem")
//    public String deleteitem(ItemCategory itemCategory){
//        itemCategoryService.delete(itemCategory);
//        return "item/itemCategoryManage";
//    }

    @GetMapping("/user/itemCategoryEdit")
    public String itemEdit(Model model,ItemCategory itemCategory){
        if(itemCategory.getId() != 0){
            ItemCategory itemCategory0 = itemCategoryService.findById(itemCategory);
            model.addAttribute("itemCategory",itemCategory0);
        }
        return "item/itemCategoryEdit";

    }

    @PostMapping("/user/itemCategoryEdit")
    public String newsCategoryEditPost(Model model, ItemCategory itemCategory, HttpSession httpSession) {
        //根据时间和随机数生成id
        Date date = new Date();
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (999 - 100 + 1)) + 10;// 获取3位随机数
        itemCategory.setCreated(date);
        itemCategory.setUpdated(date);
        List<ItemCategory> list = itemCategoryService.list1();
        String name = itemCategory.getName();
        for(ItemCategory i : list){
            if(i.getName().equals(name))
                return "redirect:itemCategory";
        }
        if(itemCategory.getId() != 0){
            itemCategoryService.update(itemCategory);
        } else {
            itemCategory.setId(rannum);
            itemCategoryService.insert(itemCategory);
        }
        return "redirect:itemCategory";
    }




    @ResponseBody
    @PostMapping("/user/itemCategoryEditState")
    public ResObject<Object> itemCategoryEditState(ItemCategory itemCategory){
        itemCategoryService.delete(itemCategory);
        ResObject<Object> object = new ResObject<Object>(Constant.Code01, Constant.Msg01, null, null);
        return object;
    }

}

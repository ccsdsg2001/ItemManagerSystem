package com.example.codesystem.Controller;

import com.example.codesystem.model.Item;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.ReItem;
import com.example.codesystem.service.ReItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cc
 * @date 2022年11月10日 23:38
 */
@Controller
public class ReItemController {

    @Autowired
    ReItemService reItemService;

    @RequestMapping("/user/recoverManage")
    public String itemRecovery( @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, Model model, String name, ReItem reitem){

        PageInfo<ReItem> byPage = reItemService.findByPage(pageNum, pageSize);
        model.addAttribute("pageInfo", byPage);
        model.addAttribute("reItem",reitem);

        return "item/recoverManage";
    }
}

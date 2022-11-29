package com.example.codesystem.Controller;

import com.example.codesystem.model.Item;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.ReItem;
import com.example.codesystem.model.ResObject;
import com.example.codesystem.service.ItemService;
import com.example.codesystem.service.ReItemService;
import com.example.codesystem.util.Constant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author cc
 * @date 2022年11月10日 23:38
 */
@Controller
public class ReItemController {

    @Autowired
    ItemService itemService;

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

    @ResponseBody
    @PostMapping("/user/reItemEditState")
    public ResObject<Object> reItemEditState(ReItem reItem) {
        ReItem reItem1 = reItemService.selectByPrimaryKey(reItem.getId());
        Item item = new Item();
        item.setId(reItem1.getId());
        item.setBarcode(reItem1.getBarcode());
        item.setCid(reItem1.getCid());
        item.setImage(reItem1.getImage());
        item.setPrice(reItem1.getPrice());
        item.setNum(reItem1.getNum());
        item.setSellPoint(reItem1.getSellPoint());
        item.setStatus(reItem1.getStatus());
        item.setTitle(reItem1.getTitle());
        item.setCreated(new Date());
        item.setUpdated(new Date());
        itemService.insert(item);
        reItemService.deleteByPrimaryKey(reItem1.getId());
        ResObject<Object> object = new ResObject<Object>(Constant.Code01, Constant.Msg01, null, null);
        return object;
    }

    @ResponseBody
    @PostMapping("/user/deleteItemEditState")
    public ResObject<Object> deleteItemEditState(ReItem reItem) {
        reItemService.deleteByPrimaryKey(reItem.getId());
        ResObject<Object> object = new ResObject<Object>(Constant.Code01, Constant.Msg01, null, null);
        return object;
    }
}

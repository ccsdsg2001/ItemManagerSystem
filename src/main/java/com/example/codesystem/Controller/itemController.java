package com.example.codesystem.Controller;

import com.example.codesystem.model.Item;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.ReItem;
import com.example.codesystem.model.ResObject;
import com.example.codesystem.service.ItemCategoryService;
import com.example.codesystem.service.ItemService;
import com.example.codesystem.service.ReItemService;
import com.example.codesystem.util.*;
import com.github.pagehelper.PageInfo;
import com.mongodb.gridfs.GridFSDBFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

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


    private final ResourceLoader resourceLoader;

    @Autowired
    public itemController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    List<Item> itemList;

    File getFile = null;

    MongoUtil mongoUtil = new MongoUtil();

    public static final String ROOT = "src/main/resources/static/img/item/";

    @Autowired
    ItemCategoryService itemCategoryService;

    @RequestMapping("/user/itemManage")
    public String itemManage(ItemCategory itemCategory,
                             @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize,
                             Model model, String name, Item item){

        PageInfo<Item> byPage = itemService.findByPage(pageNum, pageSize);


//        PageInfo<Item> byPagetest = itemService.findByPagetest(pageNum, pageSize, item);
        for (Item i : byPage.getList()) {
            i.setUpdatedStr(DateUtil.getDateStr(i.getUpdated()));
        }

        ItemCategory itemCategory1 = new ItemCategory();
        itemCategory1.setStart(0);
        itemCategory1.setEnd(Integer.MAX_VALUE);
        List<ItemCategory> itemCategoryList = itemCategoryService.list(itemCategory1);
        Integer minPrice=item.getMinPrice();
        Integer maxPrice=item.getMaxPrice();


        model.addAttribute("itemCategoryList", itemCategoryList);
        model.addAttribute("pageInfo",byPage);
        model.addAttribute("item", item);
//        model.addAttribute("pageInfo", itemList);
        return "item/itemManage";

    }


    @RequestMapping("/user/itemManageSearch")
    public String itemManageSearch(ItemCategory itemCategory,
                                   @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize,
                                   Model model, String title, Item item,Integer cid ){

        PageInfo<Item> bysearch = itemService.findBysearch(pageNum, pageSize, title, cid);
        model.addAttribute("pageInfo", bysearch);


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

    String imageName = null;

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
            GridFSDBFile fileById = mongoUtil.getFileById(id);
            if(fileById!=null){
                StringBuilder sb = new StringBuilder(ROOT);
                imageName=fileById.getFilename();
                sb.append(imageName);
                try {
                    getFile = new File(sb.toString());
                    fileById.writeTo(getFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                item1.setImage(imageName);

            }
            model.addAttribute("item", item1);


        }

        return "item/itemEdit";
    }


    @PostMapping("/user/itemEdit")
    public String itemEditPost(Model model, HttpServletRequest request,
                               @RequestParam("file") MultipartFile file,
                               Item item, HttpSession httpSession){

        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        item.setBarcode("");
        item.setImage("");
        int rannum=0;
        if (file.isEmpty()) {
            System.out.println("图片未上传");
        } else {
            try {
                Path path = Paths.get(ROOT, file.getOriginalFilename());
                File tempFile = new File(path.toString());
                if (!tempFile.exists()) {
                    Files.copy(file.getInputStream(), path);
                }
                LinkedHashMap<String, Object> metaMap = new LinkedHashMap<String, Object>();
                String id = null;
                if (item.getId() != 0) {
                    id = String.valueOf(item.getId());
                } else {
                    Random random = new Random();
                    rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 1000;// 获取5位随机数
                    id = String.valueOf(rannum);
                }
                metaMap.put("contentType", "jpg");
                metaMap.put("_id", id);
                mongoUtil.uploadFile(tempFile, id, metaMap);
                tempFile.delete();
                getFile.delete();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("get File by Id Success");
        }

        if (item.getId() != 0) {
            itemService.update(item);
        } else {

            item.setId(rannum);
            itemService.insert(item);
        }

        return "redirect:itemManage";
    }

    @RequestMapping("/user/download1")
    public void postItemExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //导出excel
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
        fieldMap.put("id", "商品id");
        fieldMap.put("title", "商品标题");
        fieldMap.put("sellPoint", "商品卖点");
        fieldMap.put("price", "商品价格");
        fieldMap.put("num", "库存数量");
        fieldMap.put("image", "商品图片");
        fieldMap.put("cid", "所属类目，叶子类目");
        fieldMap.put("status", "商品状态，1-正常，2-下架，3-删除");
        fieldMap.put("created", "创建时间");
        fieldMap.put("updated", "更新时间");
        String sheetName = "商品管理报表";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=ItemManage.xls");//默认Excel名称
        response.flushBuffer();
        OutputStream fos = response.getOutputStream();
        try {
            ExcelUtil.listToExcel(itemList, fieldMap, sheetName, fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping(value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile() {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, imageName).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}

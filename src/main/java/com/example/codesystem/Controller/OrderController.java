package com.example.codesystem.Controller;

import com.example.codesystem.model.Item;
import com.example.codesystem.model.ItemCategory;
import com.example.codesystem.model.Order;
import com.example.codesystem.model.OrderItem;
import com.example.codesystem.service.OrderItemService;
import com.example.codesystem.service.OrderService;
import com.example.codesystem.util.DateUtil;
import com.example.codesystem.util.ExcelUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author cc
 * @date 2022年11月04日 21:27
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    List<Order> orderList;

    @RequestMapping("/user/orderManage")
    public String orderManage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize, Model model, String name, Item item, Order order){

        PageInfo<Order> pageInfo = orderService.findByPage(pageNum, pageSize);
        String itemTitle = pageInfo.getList().get(2).getItemTitle();

        for(int i = 0;i<=pageInfo.getList().size();i++){

        }

        for (Order order1 : pageInfo.getList()) {
            String orderId = order1.getOrderId();
            if (orderItemService.selectByPrimaryOrderKey(orderId) != null) {
                OrderItem orderItem = orderItemService.selectByPrimaryOrderKey(orderId);
                order1.setItemTitle(orderItem.getTitle());
                order1.setTotalFee(orderItem.getTotalFee());
                order1.setNum(orderItem.getNum());
                order1.setStatusStr(getStatusStrById(order1.getStatus()));
                order1.setDateStr1(DateUtil.getDateStr(order1.getCreateTime()));
                order1.setPaymentTypeStr(getPaymentTypeById(order1.getPaymentType()));
            }
        }//遍历数据


        orderList = orderService.list(order);
        for (Order order1 : orderList) {
            String orderId = order1.getOrderId();
            if (orderItemService.selectByPrimaryOrderKey(orderId) != null) {
                OrderItem orderItem = orderItemService.selectByPrimaryOrderKey(orderId);
                order1.setItemTitle(orderItem.getTitle());
                order1.setTotalFee(orderItem.getTotalFee());
                order1.setNum(orderItem.getNum());
                order1.setStatusStr(getStatusStrById(order1.getStatus()));
                order1.setDateStr1(DateUtil.getDateStr(order1.getCreateTime()));
                order1.setPaymentTypeStr(getPaymentTypeById(order1.getPaymentType()));
            }
        }//下载

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("order", order);

        return "order/orderManage";
    }


    @RequestMapping("/user/ordermanagersearch")
    public String ordermanagersearch(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize, Model model, Integer paymentType,Integer status){

        PageInfo<Order> orderPageInfo = orderService.listByPaymentTypeAndStatus(pageNum, pageSize, paymentType, status);
        for (Order order1 : orderPageInfo.getList()) {
            String orderId = order1.getOrderId();
            if (orderItemService.selectByPrimaryOrderKey(orderId) != null) {
                OrderItem orderItem = orderItemService.selectByPrimaryOrderKey(orderId);
                order1.setItemTitle(orderItem.getTitle());
                order1.setTotalFee(orderItem.getTotalFee());
                order1.setNum(orderItem.getNum());
                order1.setStatusStr(getStatusStrById(order1.getStatus()));
                order1.setDateStr1(DateUtil.getDateStr(order1.getCreateTime()));
                order1.setPaymentTypeStr(getPaymentTypeById(order1.getPaymentType()));
            }
        }//遍历数据
        model.addAttribute("pageInfo",orderPageInfo);


        return "order/orderManage";
    }



    @RequestMapping("/user/orderRefund")
    public String refund(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize, Model model,
                         String name, Item item, Order order){


        PageInfo<Order> byPagebyrefund = orderService.findByPagebyrefund(pageNum, pageSize, order);


        for (Order order1 : byPagebyrefund.getList()) {
            String orderId = order1.getOrderId();
            if (orderItemService.selectByPrimaryOrderKey(orderId) != null) {
                OrderItem orderItem = orderItemService.selectByPrimaryOrderKey(orderId);
                order1.setItemTitle(orderItem.getTitle());
                order1.setTotalFee(orderItem.getTotalFee());
                order1.setNum(orderItem.getNum());
                order1.setStatusStr(getStatusStrById(order1.getStatus()));
                order1.setDateStr1(DateUtil.getDateStr(order1.getCreateTime()));
                order1.setPaymentTypeStr(getRefundStatusStr(order1.getPaymentType()));

                order1.setPaymentTypeStr(getPaymentTypeById(order1.getPaymentType()));
//                order1.setRefundStatusStr(getRefundStatusStr(order1.getRefundStatus()));
            }
        }//遍历数据

        model.addAttribute("orderList", orderList);
        model.addAttribute("pageInfo",byPagebyrefund);
        model.addAttribute("order", order);
        return "order/orderRefund";

    }

    @GetMapping("/user/orderDetails")
    public String orderDetails(Model model,Order order){
        String orderId = order.getOrderId();
        Order order1 = orderService.selectByPrimaryKey(orderId);
        if (orderItemService.selectByPrimaryOrderKey(orderId) != null) {
            OrderItem orderItem = orderItemService.selectByPrimaryOrderKey(orderId);
            order1.setItemTitle(orderItem.getTitle());
            order1.setTotalFee(orderItem.getTotalFee());
            order1.setNum(orderItem.getNum());
            order1.setStatusStr(getStatusStrById(order1.getStatus()));
            order1.setItemId(orderItem.getItemId());
            order1.setBuyerRateStr(getbuyerRateStrById(order1.getBuyerRate()));
            order1.setDateStr1(DateUtil.getDateStr(order1.getCreateTime()));
            order1.setDateStr2(DateUtil.getDateStr(order1.getUpdateTime()));
            order1.setDateStr3(DateUtil.getDateStr(order1.getPaymentTime()));
            order1.setDateStr4(DateUtil.getDateStr(order1.getConsignTime()));
            order1.setDateStr5(DateUtil.getDateStr(order1.getEndTime()));
            order1.setPaymentTypeStr(getPaymentTypeById(order1.getPaymentType()));

            model.addAttribute("order", order1);
        }
        return "order/orderDetails";
    }


    @RequestMapping("/user/searchByrefundStatusStr")
    public String searchByRefundStatus(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize, Model model,
                                       String name, Item item, Order order ,String refundStatusStr ){

        PageInfo<Order> orderPageInfo = orderService.searchByrefundStatusStr(pageNum, pageSize, refundStatusStr);


        for (Order order1 : orderPageInfo.getList()) {
            String orderId = order1.getOrderId();
            if (orderItemService.selectByPrimaryOrderKey(orderId) != null) {
                OrderItem orderItem = orderItemService.selectByPrimaryOrderKey(orderId);
                order1.setItemTitle(orderItem.getTitle());
                order1.setTotalFee(orderItem.getTotalFee());
                order1.setNum(orderItem.getNum());
                order1.setStatusStr(getStatusStrById(order1.getStatus()));
                order1.setDateStr1(DateUtil.getDateStr(order1.getCreateTime()));
                order1.setPaymentTypeStr(getRefundStatusStr(order1.getPaymentType()));

                order1.setPaymentTypeStr(getPaymentTypeById(order1.getPaymentType()));
//                order1.setRefundStatusStr(getRefundStatusStr(order1.getRefundStatus()));
            }
        }


        model.addAttribute("pageInfo", orderPageInfo);


        return "order/orderRefund";
    }

    @PostMapping("/user/orderDetails")
    public String orderDetailsPost(Model model, @RequestParam MultipartFile[] imageFile, HttpSession httpSession) {
        //根据时间和随机数生成id
        return null;
    }

    public String getRefundStatusStr(int i) {
        switch (i) {
            case 1:
                return "申请退款";
            case 2:
                return "退款失败";
            case 3:
                return "退款成功";
        }
        return null;
    }

    public String getbuyerRateStrById(int i) {
        switch (i) {
            case 0:
                return "否";
            case 1:
                return "是";
        }
        return null;
    }


    public String getStatusStrById(int i) {
        switch (i) {
            case 1:
                return "未付款";
            case 2:
                return "已付款";
            case 3:
                return "未发货";
            case 4:
                return "已发货";
            case 5:
                return "交易成功";
            case 6:
                return "交易关闭";
        }
        return null;
    }

    public String getPaymentTypeById(int i) {
        switch (i) {
            case 1:
                return "在线支付";
            case 2:
                return "货到付款";
        }
        return null;
    }

    @RequestMapping("/user/download2")
    public void Download(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //导出excel
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
        fieldMap.put("orderId", "订单id");
        fieldMap.put("payment", "实付金额");
        fieldMap.put("paymentType", "支付类型，1、在线支付，2、货到付款");
        fieldMap.put("postFee", "邮费");
        fieldMap.put("status", "状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭");
        fieldMap.put("createTime", "订单创建时间");
        fieldMap.put("updateTime", "订单更新时间");
        fieldMap.put("paymentTime", "付款时间");
        fieldMap.put("consignTime", "发货时间");
        fieldMap.put("endTime", "交易完成时间");
        fieldMap.put("closeTime", "交易关闭时间");
        fieldMap.put("shippingName", "物流名称");
        fieldMap.put("shippingCode", "物流单号");
        fieldMap.put("userId", "用户id");
        fieldMap.put("buyerMessage", "买家留言");
        fieldMap.put("buyerNick", "买家昵称");
        fieldMap.put("buyerRate", "买家是否已经评价");
        String sheetName = "订单报表";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=OrderManage.xls");//默认Excel名称
        response.flushBuffer();
        OutputStream fos = response.getOutputStream();
        try {
            ExcelUtil.listToExcel(orderList, fieldMap, sheetName, fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/user/orderCheck")
    public String orderCheckGet(Model model, Order order) {
        String orderId = order.getOrderId();
        Order order1 = orderService.selectByPrimaryKey(orderId);
        if (orderItemService.selectByPrimaryOrderKey(orderId) != null) {
            OrderItem orderItem = orderItemService.selectByPrimaryOrderKey(orderId);
            order1.setItemTitle(orderItem.getTitle());
            order1.setTotalFee(orderItem.getTotalFee());
            order1.setNum(orderItem.getNum());
            order1.setStatusStr(getStatusStrById(order1.getStatus()));
            order1.setItemId(orderItem.getItemId());
            order1.setBuyerRateStr(getbuyerRateStrById(order1.getBuyerRate()));
            order1.setDateStr1(DateUtil.getDateStr(order1.getCreateTime()));
            order1.setDateStr3(DateUtil.getDateStr(order1.getPaymentTime()));
            order1.setPaymentTypeStr(getPaymentTypeById(order1.getPaymentType()));
            order1.setRefundStatus(null);
            model.addAttribute("order", order1);
        }
        return "order/orderCheck";
    }

    @PostMapping("/user/orderCheck")
    public String orderCheckPost(Model model, @RequestParam MultipartFile[] imageFile, Order order, HttpSession httpSession) {

        if (order.getRefundStatus() == null) {
            order.setRefundStatus(0);
        }
        if (order.getOrderId() != null) {
            orderService.updateByPrimaryKey(order);
        }
        return "redirect:orderRefund";
    }

}

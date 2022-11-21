package com.example.demo1.web;

import com.example.demo1.dao.OrdersDao;
import com.example.demo1.model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.sql.RowSet;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrdersDao ordersDao;
    @GetMapping("/toOrdersList")
    public String toOrdersList(Model model,HttpSession session) {
        List<Orders> ordersList = ordersDao.getordersList(session.getAttribute("userName").toString());
        System.out.println(ordersList.toString());
        //讲用户的列表数据 保存在model中  便于前段页面去获取和渲染数据
        model.addAttribute("ordersList", ordersList);
        return "ordersList";
    }
    @GetMapping("/toDeleteOrders")
    public String toDeleteOrders(int spid) {
        int i = ordersDao.deleteOrders(spid);
        return "redirect:toOrdersList";
    }
    @GetMapping("/toEditOrders")
    public String toEditOrders(int spid,Model model) {
        Orders orders = ordersDao.getorderById(spid);
        model.addAttribute("orders",orders);
        return "updateOrders";
    }
    @PostMapping("/handleUpdateOrders")
    public String handleUpdateOrders(Orders orders) {
        int i = ordersDao.updateorders(orders);
        return "redirect:toOrdersList";
    }
    @GetMapping("toaddOrders")
    public String toaddOrders(Model model,HttpSession session) {
        return "addOrders";
    }
    @PostMapping("/handleAddOrders")
    public String handleAddOrders(Orders orders) {
        ordersDao.addorders(orders);
        return "redirect:toOrdersList";
    }
}

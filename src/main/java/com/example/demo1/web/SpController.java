package com.example.demo1.web;

import com.example.demo1.dao.SpDao;
import com.example.demo1.model.Orders;
import com.example.demo1.model.Sp;
import com.example.demo1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Name;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SpController {
    @Autowired
    SpDao spDao;
    @GetMapping("/toSpList")
    public String toSpList(Model model, HttpSession session) {
        List<Sp> spList = spDao.getSpList();
        System.out.println(spList.toString());
        //讲用户的列表数据 保存在model中  便于前段页面去获取和渲染数据
        model.addAttribute("spList", spList);
        return "spList";
    }
    @GetMapping("/toDeleteSp")
    public String toDeleteSp(int id) {
        int i = spDao.DeleteSp(id);
        return "redirect:toSpList";
    }
    @GetMapping("toBuyList")
    public String toBuyList(Model model,HttpSession session) {
        return "buyList";
    }
    @PostMapping("/handleUpdateBuy")
    public String handleUpdateOrders(Orders orders) {
        spDao.insertbuy(orders);
        return "redirect:toOrdersList";
    }
    @GetMapping("togList")
    public String toGList(int id,Model model) {
        Sp sp = spDao.getspById(id);
        model.addAttribute("sp",sp);
        return "gList";
    }
    @PostMapping("/handleUpdateG")
    public String handleUpdateG(Sp sp) {
        spDao.updatesp(sp);
        return "redirect:toSpList";
    }



}

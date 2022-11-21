package com.example.demo1.web;

import com.example.demo1.dao.UserDao;
import com.example.demo1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public String toReg() {


        return "reg";
    }


    @GetMapping("/toYzList")
    public String toYzList(User user) {
        return "yzList";
    }
    @PostMapping  ("/hendleyz")
    public String tohendleyz(User user, Model model) {
        if (!user.getUserName().equals("966877")){
            return "yzFail";
        }
        else {
            return "redirect:toUserList";
        }
    }

    @GetMapping("/toUserList")
    public String toUserList(Model model) {

        //从数据库中查询出所有的用户数据
        List<User> userList = userDao.getUserList();
        System.out.println(userList.toString());
        //讲用户的列表数据 保存在model中  便于前段页面去获取和渲染数据
        model.addAttribute("userList", userList);

        return "userList";
    }




    @GetMapping("/handleReg")
    public String handleReg(User user, Model model) {
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("msg", "两次输入的密码不一致");
            return "regFail";
        } else if (userDao.countUserByUserName(user.getUserName()) == 1) {
            model.addAttribute("msg", "该账号已经被注册过了");
            return "regFail";
        } else {
            //用户的注册数据 保存到数据库
            userDao.addUser(user);
            return "login";
        }
    }






    @GetMapping("/handleLogin")
    public String handleLogin(User user, HttpSession session) {
        int i = userDao.handleLogin(user);
        if (i == 1) {
            System.out.println("登录的用户账号是：" + user.getUserName());
            session.setAttribute("userName", user.getUserName());
            return "home";
        } else {
            return "loginFail";
        }
    }

    @GetMapping("/toDeleteUser")
    public String toDeleteUser(int id) {
        int i = userDao.deleteUser(id);
        return "redirect:toUserList";
    }



    @GetMapping("/toEditUser")
    public String toEditUser(int id,Model model) {
        User user = userDao.getUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }
    // handleUpdateUser
    @PostMapping("/handleUpdateUser")
    public String handleUpdateUser(User user) {
        int i = userDao.updateUser(user);
        return "redirect:toUserList";
    }




    @GetMapping("toaddUser")
    public String toaddOrders(Model model,HttpSession session) {
        return "addUser";
    }
    @PostMapping("/handleAddUser")
    public String handleAddOrders(User user) {
        userDao.addUser(user);
        return "redirect:toUserList";
    }





}


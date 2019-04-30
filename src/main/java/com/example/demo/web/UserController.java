package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
* @Description:    用户crud操作
* @Author:         lxl
* @CreateDate:     2019/4/30 11:13
* @UpdateRemark:
* @Version:
*/
@Controller
@RequestMapping()
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表显示
     * @param model
     * @return
     */
    //返回页面
    @RequestMapping(value = "/test")
    public String test(Model model){
        return "Pagination";
    }

    //返回数据
    @ResponseBody
    @RequestMapping(value = "list")
    public List<User> userList(){
        return userService.queryUserList();
    }

    //首页展示
    @RequestMapping(value = "index")
    public String index(Model model){
        User user =userService.queryUserById(1);
        model.addAttribute("user",user);
        return "index";
    }

    /**
     * 添加用户
     * @return
     */
    //返回页面
    @RequestMapping(value = "add")
    public String addUser(){
         return "userAdd";
    }
    //返回数据
    @ResponseBody
    @RequestMapping(value = "data", produces = "application/json; charset=utf-8")
    public Integer data(User search) {
        Integer num = userService.addUser(search);
        return num;
    }
    /**
     * 根据id删除用户
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public int deleteUserById(){
        int num=userService.deleteUserById(125);
        return num;
    }

    /**
     * 根据id修改用户信息
     */
  /*  @RequestMapping(value = "update")
    public String update(Model model){
        User user =userService.queryUserById(1);
        //model.addAttribute("user",user);
        return "userAdd";
    }*/
    @ResponseBody
    @RequestMapping(value = "update")
    public int updateData(){
        User user = new User();
        user.setUserName("张三");
       return userService.updateUserById(124);
    }


}

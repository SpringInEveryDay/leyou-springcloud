package com.leyou.demo.userconsumerdemo.controller;

import com.leyou.demo.userconsumerdemo.pojo.User;
import com.leyou.demo.userconsumerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:ConsumerController
 * @Description:
 * @author:chenyun
 * @Date:2019/11/27 16:34
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    //注入service
    @Autowired
    private UserService userService;


    //返回用户列表
    @GetMapping
    public List<User> queryUsersByIds(@RequestParam("ids") List<Long> ids){
        return userService.queryUsersByIds(ids);
    }
}

package com.leyou.demo.userservicedemo.controller;

import com.leyou.demo.userservicedemo.pojo.User;
import com.leyou.demo.userservicedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName:UserController
 * @Description:
 * @author:chenyun
 * @Date:2019/11/27 15:57
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryUserById(@PathVariable("id") Long id){
        return userService.queryUserById(id);
    }

}

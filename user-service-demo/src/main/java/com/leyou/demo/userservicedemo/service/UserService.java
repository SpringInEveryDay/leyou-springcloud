package com.leyou.demo.userservicedemo.service;

import com.leyou.demo.userservicedemo.mapper.UserMapper;
import com.leyou.demo.userservicedemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:UserService
 * @Description:
 * @author:chenyun
 * @Date:2019/11/27 16:07
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User queryUserById(Long id) {
        //然后根据id查
        return userMapper.selectByPrimaryKey(id);

    }
}

package com.leyou.demo.userconsumerdemo.service;

import com.leyou.demo.userconsumerdemo.mapper.UserMapper;
import com.leyou.demo.userconsumerdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:UserService
 * @Description:
 * @author:chenyun
 * @Date:2019/11/27 16:41
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> queryUsersByIds(List<Long> ids) {
        //遍历这个id的集合返回用户的集合信息
        List<User> users = new ArrayList<>();
        //遍历id的list
        for(Long id : ids){
            //调用UserMapper
            User user = userMapper.queryUserById(id);
            users.add(user);
        }

        return users;
    }
}

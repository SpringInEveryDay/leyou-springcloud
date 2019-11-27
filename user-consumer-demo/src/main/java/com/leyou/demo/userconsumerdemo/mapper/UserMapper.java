package com.leyou.demo.userconsumerdemo.mapper;

import com.leyou.demo.userconsumerdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:UserMapper
 * @Description:
 * @author:chenyun
 * @Date:2019/11/27 16:44
 */
@Component
public class UserMapper {
    //注入远程客户端工具
    @Autowired
    private RestTemplate restTemplate;

    //这里没有使用通用mapper什么的查询数据库，而是使用RestTemplate远程查询user-service-demo中的接口
    public User queryUserById(Long id) {
        //定义一个远程接口地址
        String url = "http://localhost:8081/user/" + id;
        return restTemplate.getForObject(url,User.class);
    }
}

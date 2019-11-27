package com.leyou.demo.userconsumerdemo.service;

import com.leyou.demo.userconsumerdemo.mapper.UserMapper;
import com.leyou.demo.userconsumerdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;
    //使用DiscoveryClient类的方法，根据服务的名称获取服务的实例
    @Autowired
    private DiscoveryClient discoveryClient;

    public List<User> queryUsersByIds(List<Long> ids) {
        //遍历这个id的集合返回用户的集合信息
        List<User> users = new ArrayList<>();
        //根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //因为在这个搭建的架构里只有一个UserService，因此我们直接使用get(0)获取
        ServiceInstance instance = instances.get(0);
        //获取ip和端口信息
        String baseUrl = "http://"+instance.getHost()+":"+instance.getPort()+"/user/";
        //然后使用forEach循环进行遍历
        ids.forEach(id -> {
            User user = restTemplate.getForObject(baseUrl + id, User.class);
            //将每次循环出来的user结果添加到集合中
            users.add(user);
            //每次间隔500毫秒去拿
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return users;
    }
}

package com.leyou.demo.userservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//在启动类上开启EurekaClient的客户端功能
@EnableDiscoveryClient
public class UserServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceDemoApplication.class, args);
    }

}

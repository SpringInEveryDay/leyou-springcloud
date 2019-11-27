package com.leyou.demo.userconsumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//以下在启动类的注解中加入exclude如下内容目的是为了在启动服务的时候不去找配置文件中的内容
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//在启动类中开启eureka客户端
@EnableDiscoveryClient
public class UserConsumerDemoApplication {

    //使用远程RestTemplate
    @Bean
    public RestTemplate restTemplate(){
        //使用OKHttp客户端，只需要注入工厂即可
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }


    public static void main(String[] args) {
        SpringApplication.run(UserConsumerDemoApplication.class, args);
    }

}

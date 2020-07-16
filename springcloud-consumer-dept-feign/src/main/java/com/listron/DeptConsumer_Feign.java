package com.listron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.listron")
@ComponentScan("com.listron")
public class DeptConsumer_Feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign.class,args);
    }
}

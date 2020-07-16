package com.listron.controller;

import com.listron.pojo.Dept;
import com.listron.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供restful 服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet") //服务熔断
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException("id=>"+id+"不存在该用户，或者信息无法找到～");
        }
        return dept;
    }

    //备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDno(id)
                .setDname("id=>"+id+"不存在该用户，或者信息无法找到～")
                .setDb_source("没有对应的数据库");
    }
}

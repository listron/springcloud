package com.listron.controller;

import com.listron.pojo.Dept;
import com.listron.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@EnableEurekaClient
public class DeptConsumerController {

    //理解：消费者，不应该有service层，
    @Autowired
    public DeptClientService service;

    @GetMapping("/consumer/dept/get/{dno}")
    public Dept get(@PathVariable("dno") Long dno){
        return service.queryById(dno);
    }

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return service.addDept(dept);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return service.queryAll();
    }
}

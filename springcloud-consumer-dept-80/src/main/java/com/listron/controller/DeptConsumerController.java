package com.listron.controller;

import com.listron.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@EnableEurekaClient
public class DeptConsumerController {

    //理解：消费者，不应该有service层，
    // RestTemplate 供我们直接调用就可以了，注册到spring中

    @Autowired
    private RestTemplate restTemplate;//简单的restful服务模版

    //ribbon 负载均衡的实现，我们这里的地址，是一个变量，通过服务来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
    //private static final String REST_URL_PREFIX = "http://localhost:8001";

    @GetMapping("/consumer/dept/get/{dno}")
    public Dept get(@PathVariable("dno") Long dno){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/" + dno,Dept.class);
    }

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get", List.class);
    }
}

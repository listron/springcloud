package com.listron.controller;

import com.listron.pojo.Dept;
import com.listron.service.DeptService;
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
    //获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{dno}")
    public Dept get(@PathVariable("dno") Long dno){
        Dept dept = deptService.queryById(dno);
        if(dept == null){
            throw new RuntimeException("dno=>"+dno+"不存在该用户，或者信息无法找到～");
        }
        return dept;
    }

    @GetMapping("/dept/get")
    public List<Dept> getList(){
        return deptService.queryAll();
    }
    //服务发现，团队协作
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表清单
        List<String> services = discoveryClient.getServices();
        System.out.print("services=>"+services);

        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance serviceInstance:instances){
            System.out.print(
                    "\n"+
                    serviceInstance.getHost()+"\n"+
                    serviceInstance.getPort()+"\n"+
                    serviceInstance.getUri()+"\n"+
                    serviceInstance.getServiceId()
            );
        }
        return this.discoveryClient;
    }
}

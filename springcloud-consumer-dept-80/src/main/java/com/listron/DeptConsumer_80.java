package com.listron;

import com.rule.ListronRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
//在微服务启动的时候就能去加载我们自定义的ribbon策略类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = ListronRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}

package com.listron.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //Configuration 相当于spring中的 applicationContext.xml


    //注册到RestTemplate
    //IRule
    //RoundRobinRule 轮询
    //RandomRule 随机
    //AvailabilityFilteringRule  过滤掉有问题的服务后，进行轮询
    @Bean
    @LoadBalanced //ribbon 配置负载均衡实现，加个注解即可
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule(){
//        return  new RandomRule();
//    }



}

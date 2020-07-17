package com.listron.service;

import com.listron.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientSericeFailBack implements FallbackFactory {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public boolean addDept(Dept dept) {
                return false;
            }

            public Dept queryById(Long dno) {
                return new Dept()
                        .setDno(dno)
                        .setDname("服务出现问题")
                        .setDb_source("没有此数据");
            }

            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}

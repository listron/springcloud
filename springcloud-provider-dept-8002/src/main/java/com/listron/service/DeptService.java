package com.listron.service;

import com.listron.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(Long dno);

    public List<Dept> queryAll();
}

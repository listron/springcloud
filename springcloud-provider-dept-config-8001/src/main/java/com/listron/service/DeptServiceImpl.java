package com.listron.service;

import com.listron.dao.DeptDao;
import com.listron.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept queryById(Long dno) {
        return deptDao.queryById(dno);
    }

    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}

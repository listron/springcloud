package com.listron.dao;

import com.listron.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept queryById(Long dno);

    public List<Dept> queryAll();

}

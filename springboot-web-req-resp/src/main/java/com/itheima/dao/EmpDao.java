package com.itheima.dao;

import com.itheima.pojo.Emp;

import java.util.List;

public interface EmpDao {
    //这个接口的主要功能是获取员工列表的数据

    public List<Emp> listEmp();
}

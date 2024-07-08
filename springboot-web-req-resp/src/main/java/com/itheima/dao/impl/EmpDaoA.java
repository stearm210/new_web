package com.itheima.dao.impl;

import com.itheima.dao.EmpDao;
import com.itheima.pojo.Emp;
import com.itheima.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component//将当前类交给IOC容器管理,成为IOC容器中的bean

//可用于声明一个bean
@Repository//标注在数据访问类上(由于与mybatis整合，用的少)

public class EmpDaoA implements EmpDao{
    //实现接口的实现类
    @Override
    public List<Emp> listEmp() {
        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList= XmlParserUtils.parse(file, Emp.class);
        return empList;
    }


}
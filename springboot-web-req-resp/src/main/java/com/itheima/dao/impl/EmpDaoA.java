package com.itheima.dao.impl;

import com.itheima.dao.EmpDao;
import com.itheima.pojo.Emp;
import com.itheima.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component//将当前类交给IOC容器管理,成为IOC容器中的bean
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
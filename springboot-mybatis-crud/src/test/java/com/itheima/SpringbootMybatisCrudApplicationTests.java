package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

//这个类主要是用于测试操作的
@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired//用于注入注解
    private EmpMapper empMapper;

    @Test
    public void testDelete(){
        int delete=empMapper.delete(16);

        //输出删除操作影响到的数据库中的记录数
        System.out.println(delete);
    }

    @Test
    //插入的数据最后保存到了mysql数据库中等待被操作
    public void testInsert(){
        //构造员工对象
        Emp emp=new Emp();
        emp.setUsername("Tom3");
        emp.setName("汤姆3");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        //这里构造了一个对象更加方便
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行新增员工信息操作
        empMapper.insert(emp);

        //获取主键
        System.out.println(emp.getId());
    }
}

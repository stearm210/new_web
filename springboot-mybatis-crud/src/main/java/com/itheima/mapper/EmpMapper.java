package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

//这个mapper包中主要是用于编写SQL的操作代码的
//接口本质上是一个实现类
//这里用了一个mapper注解，并且定义了一个接口类empmapper进行sql语句的编写和操作
@Mapper
public interface EmpMapper {
    //根据ID删除数据
    //这里使用注解
    //这里的注解后面跟上的是sql语句

    //使用#{id},主要是进行预编译操作问题
    //使用#{id}，id是数据库中的主键信息，主要是用于sql语句的删除操作

    @Delete("delete from emp where id = #{id}")
    //public void delete(Integer id);

    //这里的delete的返回值表示此次操作影响到的数据库中的记录数
    //比方说这次操作到底删除了几个记录
    public int delete(Integer id);


    //新增员工操作
    //使用注解
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)\n" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{dept_id},#{create_time},#{update_time})")
    public void insert(Emp emp);
}

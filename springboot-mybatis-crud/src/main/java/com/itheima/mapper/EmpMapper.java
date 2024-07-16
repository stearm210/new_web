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
    //这里的options注解可以用于返回主键操作
    @Options(useGeneratedKeys = true,keyProperty = "id")
    //使用注解进行插入操作
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)\n" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);



    //更新员工操作
    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime}\n" +
            "where id=#{id}")

    //更新的参数有许多，因此这里使用一个Emp参数进行参数接待推送
    public void update(Emp emp);


    //根据id来查询员工
    //方案三：在application.properties中编写代码开启mybatis驼峰自动命名映射开关
    @Select("select * from emp where id=#{id}")
    public Emp getById(Integer id);

    //方案一：给字段起别名，使得别名与实体类属性一致
//    @Select("select id, username, password, name, gender, image, job, entrydate,"+" dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id}")
//    public Emp getById(Integer id);

    //方案二：通过@Results,@Result注解手动映射封装
//    @Results({
//            @Result(column = "dept_id",property = "deptId"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })
//    @Select("select * from emp where id=#{id}")
//    public Emp getById(Integer id);




}

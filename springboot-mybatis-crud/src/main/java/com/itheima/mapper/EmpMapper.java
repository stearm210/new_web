package com.itheima.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {
    //根据ID删除数据
    //这里使用注解
    @Delete("delete from emp where id = #{id}")
    //public void delete(Integer id);

    //这里的delete的返回值表示此次操作影响到的数据库中的记录数
    //比方说这次操作到底删除了几个记录
    public int delete(Integer id);
}

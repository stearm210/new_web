package com.itheima;

import com.itheima.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

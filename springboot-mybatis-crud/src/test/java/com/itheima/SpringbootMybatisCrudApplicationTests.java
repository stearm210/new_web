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
        empMapper.delete(17);
    }
}

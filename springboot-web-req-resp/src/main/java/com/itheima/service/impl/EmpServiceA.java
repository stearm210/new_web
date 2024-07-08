package com.itheima.service.impl;

import com.itheima.dao.EmpDao;
import com.itheima.dao.impl.EmpDaoA;
import com.itheima.pojo.Emp;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component//将当前类交给IOC容器管理,成为IOC容器中的

//这里可以使用component中的衍生层进行定义操作
@Service //用于标注在业务类上

public class EmpServiceA implements EmpService {

    @Autowired//运行时，IOC容器会提供该类型的bean对象，并赋值给这个变量，实现依赖注入

    //创建一个dao层的对象，对之前的数据进行处理
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        //1.调用dao，获取数据
        List<Emp> empList = empDao.listEmp();

        //2.对数据进行转化处理
        empList.stream().forEach(emp -> {
            //处理gender 1:男 ，2：女
            String gender=emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }

            //处理job工作字段问题
            //1:讲师，2：班主任，3：就业指导
            String job=emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }

        });
        return empList;
    }
}
package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired//运行时，IOC容器会提供该类型的bean对象，并赋值给这个变量，实现依赖注入


    //controller:控制层，接收前端发送的请求，对请求进行处理，并响应数据。
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list(){
//        //1.加载并且解析这份.xml文件
//        //使用对应方法查看文件所在的路径
//        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> empList= XmlParserUtils.parse(file, Emp.class);
//
//        //2.对数据进行转化处理
//        empList.stream().forEach(emp -> {
//            //处理gender 1:男 ，2：女
//            String gender=emp.getGender();
//            if("1".equals(gender)){
//                emp.setGender("男");
//            } else if ("2".equals(gender)) {
//                emp.setGender("女");
//            }
//
//            //处理job工作字段问题
//            //1:讲师，2：班主任，3：就业指导
//            String job=emp.getJob();
//            if("1".equals(job)){
//                emp.setJob("讲师");
//            } else if ("2".equals(job)) {
//                emp.setJob("班主任");
//            } else if ("3".equals(job)) {
//                emp.setJob("就业指导");
//            }
//
//        });


        //1.调用service，获取数值
        List<Emp> empList=empService.listEmp();
        //3.响应数据
        return Result.success(empList);

    }
}
package com.example.lock.jdk;

import com.example.dao.EmployeeMapper;
import com.example.entity.EmployeeDO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 2 * @Author: YongQiang.Li
 * 3 * @Date: 2021/8/5 16:48
 * 4
 */
public class MovieThread implements Runnable{


    private EmployeeMapper employeeMapper;
    private static Integer sum =10;
    private Integer id;

    public MovieThread(Integer id,EmployeeMapper employeeMapper) {
        this.id = id;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public void run() {
        EmployeeDO db = employeeMapper.queryById(id);
        System.out.println("查询的结果是："+db.toString());
    }
}

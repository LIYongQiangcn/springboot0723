package com.example.controller;

import com.example.dao.EmployeeMapper;
import com.example.entity.EmployeeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yongqiang.li
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("get")
    public List<EmployeeDO> query() {
        return employeeMapper.query();
    }

}

package com.example.controller;

import com.example.dao.EmployeeMapper;
import com.example.entity.EmployeeDO;
import com.example.util.annotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yongqiang.li
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeController(EmployeeMapper employeeMapper){
        this.employeeMapper = employeeMapper;
    }

    @LogAnnotation(desc = "My annotation")
    @GetMapping("get")
    public List<EmployeeDO> query() {
        return employeeMapper.query();
    }

    @LogAnnotation(desc = "根据Id查询内容")
    @GetMapping("getById")
    public EmployeeDO queryById(@RequestParam Integer id) {
        return employeeMapper.queryById(id);
    }

}

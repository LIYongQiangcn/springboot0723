package com.example.controller;

import com.example.dao.EmployeeMapper;
import com.example.entity.EmployeeDO;
import com.example.util.annotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yongqiang.li
 * @CrossOrigin  解决跨域注解
 */
@RestController
@RequestMapping("employee")
@CrossOrigin
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
    @LogAnnotation(desc = "手动更新数据")
    @GetMapping("update")
    public List<Integer> update() {
        List<EmployeeDO> list = employeeMapper.queryByStatus();
        List<Integer> ids = list.stream().map(EmployeeDO::getId).collect(Collectors.toList());
        employeeMapper.updateInfos(ids);
        return ids;
    }

}

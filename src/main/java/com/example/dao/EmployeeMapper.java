package com.example.dao;

import com.example.entity.EmployeeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yongqiang.li
 */
@Mapper
public interface EmployeeMapper {

    List<EmployeeDO> query();
}

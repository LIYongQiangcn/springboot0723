package com.example.dao;

import com.example.entity.EmployeeDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Yongqiang.li
 */
@Mapper
public interface EmployeeMapper {

    List<EmployeeDO> query();

    EmployeeDO queryById(Integer id);

    List<EmployeeDO> queryByStatus();

    void updateInfos(@Param("ids")List<Integer> ids);
}

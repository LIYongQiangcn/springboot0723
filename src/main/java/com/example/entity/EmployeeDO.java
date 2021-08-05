package com.example.entity;

import lombok.Data;

/**
 * @author Yongqiang.li
 */
@Data
public class EmployeeDO {
    private Integer id;
    private Integer salary;
    private Integer status;

    @Override
    public String toString() {
        return "EmployeeDO{" +
                "id=" + id +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}

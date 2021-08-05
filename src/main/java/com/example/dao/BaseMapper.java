package com.example.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2 * @Author: YongQiang.Li
 * 3 * @Date: 2021/8/4 13:05
 * 4
 */
public interface BaseMapper<T> {
    void batchUpdate(@Param("list") List<T> list);
}

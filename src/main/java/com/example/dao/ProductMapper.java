package com.example.dao;

import com.example.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * 2 * @Author: YongQiang.Li
 * 3 * @Date: 2021/7/30 14:07
 * 4
 */
@Mapper
public interface ProductMapper {

    Product selectByPrimaryKey(Integer id);
    void updateByPrimaryKey(Product productInfo);
}

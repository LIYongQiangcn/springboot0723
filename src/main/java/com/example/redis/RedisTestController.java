package com.example.redis;

import com.example.dao.ProductMapper;
import com.example.entity.Product;
import com.example.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: YongQiang.Li
 * 3 * @Date: 2021/7/30 14:19
 * 4
 */
@RestController
@RequestMapping("redis")
public class RedisTestController {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("test")
    public String createOrderTest(@RequestParam Integer id) {
        String str = redisUtil.get(id.toString());
        if (str == null) {
            Product product = productMapper.selectByPrimaryKey(id);
            if (ObjectUtils.isEmpty(product)) {
                redisUtil.set(id.toString()," ");
            }
            redisUtil.set(id.toString(),product.toString());
            return "从数据库查询: "+product.toString();
        }
        return "从redis查询";
    }

}

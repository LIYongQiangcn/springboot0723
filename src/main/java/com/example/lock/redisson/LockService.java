package com.example.lock.redisson;

import com.example.dao.ProductMapper;
import com.example.entity.Product;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 2 * @Author: YongQiang.Li
 * 3 * @Date: 2021/7/30 14:05
 * 4 秒杀 service
 */
@Service
public class LockService {


    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private ProductMapper productMapper;

    /**
     * 简单的秒杀场景实现
     * @param productId
     * @param productQuantity
     * @return
     */
    public boolean decrementProductStore(Integer productId, Integer productQuantity) {
        String key = "dec_store_lock_" + productId;
        RLock lock = redissonClient.getLock(key);
        try {
            //加锁 操作很类似Java的ReentrantLock机制
            // 1. 最常见的使用方法
            //lock.lock();

            // 2. 支持过期解锁功能,10秒钟以后自动解锁, 无需调用unlock方法手动解锁
            //lock.lock(10, TimeUnit.SECONDS);

            // 3. 尝试加锁，最多等待3秒，上锁以后60秒自动解锁
            boolean res = lock.tryLock(3, 60, TimeUnit.SECONDS);
            if(res){
                //TODO 实际这边的库存建议存在redis中，不应该直接从数据库中取库存信息
                Product productInfo = productMapper.selectByPrimaryKey(productId);
                //如果库存为空
                if (productInfo.getNum() == 0) {
                    // 库存为0，已被秒杀完
                    return false;
                }
                //简单减库存操作 没有重新写其他接口了
                productInfo.setNum(productInfo.getNum() - 1);
                productMapper.updateByPrimaryKey(productInfo);
            }else {
                //锁被占用
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

}

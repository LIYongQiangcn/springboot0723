package com.example.lock.redisson;

import com.example.lock.redisson.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: YongQiang.Li
 * 3 * @Date: 2021/7/30 15:25
 * 4
 */
@RestController
@RequestMapping("lock")
public class LockTestController {


    @Autowired
    private LockService lockService;

    @RequestMapping("test")
    public String testLock(){
        if (!lockService.decrementProductStore(1, 1)) {
            return "库存不足";
        }
        return "恭喜你成功抢到商品";
    }

}

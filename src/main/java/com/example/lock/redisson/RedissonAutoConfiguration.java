//package com.example.lock.redisson;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 2 * @Author: YongQiang.Li
// * 3 * @Date: 2021/7/30 15:23
// * 4
// */
//@Configuration
//public class RedissonAutoConfiguration {
//    @Value("${spring.redisson.address}")
//    private String addressUrl;
//    @Value("${spring.redisson.password}")
//    private String password;
//
//    /**
//     * @return org.redisson.api.RedissonClient
//     * @Author huangwb
//     * @Description //TODO 单机模式配置
//     * @Date 2020/3/19 22:54
//     * @Param []
//     **/
//    @Bean
//    public RedissonClient getRedisson() {
//        Config config = new Config();
//        config.useSingleServer()
//                .setAddress(addressUrl).setPassword(password)
//                .setRetryInterval(5000)
//                .setTimeout(10000)
//                .setConnectTimeout(10000);
//        return Redisson.create(config);
//    }
//
//}

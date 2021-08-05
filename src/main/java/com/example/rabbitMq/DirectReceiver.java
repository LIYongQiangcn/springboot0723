package com.example.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 2 * @Author: YongQiang.Li
 * 3 * @Date: 2021/8/4 17:31
 * 4
 */
@Component
@RabbitListener(queues = "DirectQueue")//监听的队列名称 DirectQueue
public class DirectReceiver {

    @RabbitHandler
    public void process(Map<String,Object> testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}

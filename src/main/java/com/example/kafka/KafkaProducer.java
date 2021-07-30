//package com.example.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 2 * @Author: YongQiang.Li
// * 3 * @Date: 2021/7/28 10:23
// * 4
// */
//@RestController
//public class KafkaProducer {
//
//    private final KafkaTemplate<String, Object> kafkaTemplate;
//
//    @Autowired
//    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//
//    @GetMapping("/kafka/normal/{message}")
//    public void sendMessage1(@PathVariable("message") String normalMessage) {
//        kafkaTemplate.send("topic1", normalMessage);
//    }
//}

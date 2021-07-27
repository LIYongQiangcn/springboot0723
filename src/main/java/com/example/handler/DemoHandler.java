package com.example.handler;

import com.example.service.DemoJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.FAIL;
import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;


/**
 * @author Yongqiang.li
 */
@Component
@RequiredArgsConstructor
public class DemoHandler {

    private final DemoJobService demoJobService;

    @XxlJob("lyqJob")
    public ReturnT<String> execute(String s1) throws Exception {
        System.out.println(" ~~~~ springboot 0703 ~~~~ ");
        XxlJobLogger.log("xxl-job测试任务开始执行。【args: {}】", s1);
        try {
            demoJobService.demoTest(s1);
            XxlJobLogger.log("xxl-job测试任务执行结束。");
            return SUCCESS;
        } catch (Exception e) {
            XxlJobLogger.log("xxl-job测试任务执行出错!", e);
            return FAIL;
        }
    }
}

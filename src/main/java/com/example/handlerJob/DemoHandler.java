package com.example.handlerJob;

import com.example.dao.EmployeeMapper;
import com.example.entity.EmployeeDO;
import com.example.service.DemoJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.xxl.job.core.biz.model.ReturnT.FAIL;
import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;


/**
 * @author Yongqiang.li
 */
@Component
@RequiredArgsConstructor
public class DemoHandler {

    private final DemoJobService demoJobService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @XxlJob("employeeJob")
    public ReturnT<String> execute(String str) throws Exception {
        XxlJobLogger.log("xxl-job测试任务开始执行。【args: {}】", str);
        List<EmployeeDO> list = employeeMapper.queryByStatus();
        if (CollectionUtils.isEmpty(list)) {
            XxlJobLogger.log("xxl-job 没有数据需要更新");
            return SUCCESS;
        }
        try {
            List<Integer> ids = list.stream().map(EmployeeDO::getId).collect(Collectors.toList());
            employeeMapper.updateInfos(ids);
            XxlJobLogger.log("xxl-job测试任务执行结束。");
            return SUCCESS;
        } catch (Exception e) {
            XxlJobLogger.log("xxl-job测试任务执行出错!", e);
            return FAIL;
        }
    }
}

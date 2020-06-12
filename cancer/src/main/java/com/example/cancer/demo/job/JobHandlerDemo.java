package com.example.cancer.demo.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * @author : linkc
 * @date : 14:51 2020/6/12
 */
@Component
public class JobHandlerDemo {

    @XxlJob(value = "demoJobHandler")
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("Hello XxlJob");
        return ReturnT.SUCCESS;
    }
}

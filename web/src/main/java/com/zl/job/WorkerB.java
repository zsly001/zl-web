package com.zl.job;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class WorkerB extends AbstractScheduleJob<EmptyTask>{

    @Override
    protected void processSingleTask(EmptyTask task, Date requestDate) {
        System.out.println(String.format("%s 执行 %s",getLockId(),new Date()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getCronTrigger() {
        return "1/5 * * * * ?";
    }

    @Override
    protected List<EmptyTask> getTasks() {
        return Arrays.asList(new EmptyTask(new Date()));
    }

    @Override
    protected String getLockId() {
        return "Worker-B";
    }
}

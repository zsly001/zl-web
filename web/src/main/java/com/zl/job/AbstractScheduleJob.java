package com.zl.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

public abstract class AbstractScheduleJob<T> {

    protected final int DEFAULT_LOCK_SECONDS = 60;

    @Autowired
    private TaskScheduler taskScheduler;



    @PostConstruct
    public void initScheduler() {
        taskScheduler.schedule(()->processTask(true), new CronTrigger(getCronTrigger()));
    }

    public void processTask(boolean needLock) {
        //加锁



        //查询数据
        List<T> tasks = getTasks();

        if (CollectionUtils.isEmpty(tasks)) {
            return;
        }

        //执行task
        for (T task : tasks) {
            try {
                processSingleTask(task, new Date());
            } catch (Exception e) {

            }
        }

    }

    /**
     * 处理单个任务
     * @param task
     * @param requestDate
     */
    protected abstract void processSingleTask(T task, Date requestDate);

    /**
     * 返回java cron表达式
     * @return string
     */
    protected abstract String getCronTrigger();

    protected abstract List<T> getTasks();

    protected abstract String getLockId();

    protected int getLockExpire(){
        return DEFAULT_LOCK_SECONDS;
    }

    private String getRedisKey() {
        String prefix = "dev";
        return "ka_java_job_" + prefix + "_" + getLockId();
    }
}

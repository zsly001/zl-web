package com.zl.job;

import java.util.Date;

public class EmptyTask {

    private Date now;

    public EmptyTask(Date now) {
        this.now = now;
    }

    public EmptyTask() {
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}

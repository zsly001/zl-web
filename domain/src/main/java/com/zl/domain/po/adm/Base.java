package com.zl.domain.po.adm;

import java.sql.Timestamp;
import java.util.Date;

public class Base {

    private Date createAt;

    private Timestamp updateAt;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}

package com.yb.pipeline.dal.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    String resourceId;
    String resourceName;
    Byte status;
    Long gmtCreate;
    Long gmtModified;

    public String getResourceId() {
        return resourceId;
    }

    public BaseEntity setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public String getResourceName() {
        return resourceName;
    }

    public BaseEntity setResourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    public Byte getStatus() {
        return status;
    }

    public BaseEntity setStatus(Byte status) {
        this.status = status;
        return this;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public BaseEntity setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public BaseEntity setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}

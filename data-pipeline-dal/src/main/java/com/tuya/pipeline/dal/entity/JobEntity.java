package com.yb.pipeline.dal.entity;

import org.apache.commons.lang3.StringUtils;

public class JobEntity extends BaseEntity {
    private static final long serialVersionUID = 4463984148909257015L;
    private long id;
    /**
     * 任务类型:1.普通定时任务
     **/
    private Byte jobType;
    private String jobCron;
    /**
     * '1:启用;2:暂停'
     **/
    private Byte jobStatus;

    public JobEntity(Builder builder) {
        this.id = builder.id;
        this.jobType = builder.jobType;
        this.jobCron = builder.jobCron;
        this.jobStatus = builder.jobStatus;
        this.resourceId = builder.resourceId;
        this.resourceName = builder.resourceName;
        this.status = builder.status;
        this.gmtCreate = builder.gmtCreate;
        this.gmtModified = builder.gmtModified;
    }

    public static JobEntity.Builder builder() {
        return new JobEntity.Builder();
    }


    public static final class Builder {
        private long id;
        private Byte jobType;
        private String jobCron;
        private Byte jobStatus;
        private String resourceId;
        private String resourceName;
        private byte status;
        private long gmtCreate;
        private long gmtModified;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder jobType(Byte jobType) {
            this.jobType = jobType;
            return this;
        }

        public Builder jobCron(String jobCron) {
            this.jobCron = jobCron;
            return this;
        }

        public Builder jobStatus(Byte jobStatus) {
            this.jobStatus = jobStatus;
            return this;
        }

        public Builder resourceId(String resourceId) {
            this.resourceId = resourceId;
            return this;
        }

        public Builder resourceName(String resourceName) {
            this.resourceName = resourceName;
            return this;
        }

        public Builder status(byte status) {
            this.status = status;
            return this;
        }

        public Builder gmtCreate(long gmCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }

        public Builder gmtModified(long gmtModified) {
            this.gmtModified = gmtModified;
            return this;
        }

        public JobEntity build() {
            if ("1".equals(this.jobType.toString()) && StringUtils.isBlank(this.jobCron)) {
                throw new RuntimeException("HttpResourceEntity resourceId is null.");
            }
            return new JobEntity(this);
        }
    }
}

package com.yb.pipeline.dal.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class HttpResourceEntity extends BaseEntity {
    private static final long serialVersionUID = 9147012814713287782L;
    private long id;
    private String uri;
    private String param;
    private byte httpType;


    public HttpResourceEntity(Builder builder) {
        this.id = builder.id;
        this.uri = builder.uri;
        this.param = builder.param;
        this.httpType = builder.httpType;
        this.resourceId = builder.resourceId;
        this.resourceName = builder.resourceName;
        this.status = builder.status;
        this.gmtCreate = builder.gmtCreate;
        this.gmtModified = builder.gmtModified;
    }
    public static HttpResourceEntity.Builder builder() {
        return new HttpResourceEntity.Builder();
    }

    public static final class Builder {
        private long id;
        private String uri;
        private String param;
        private byte httpType;
        private String resourceId;
        private String resourceName;
        private byte status;
        private long gmtCreate;
        private long gmtModified;

        public Builder() {
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder param(String param) {
            this.param = param;
            return this;
        }

        public Builder httpType(byte httpType) {
            this.httpType = httpType;
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

        public HttpResourceEntity build() {
            if (StringUtils.isBlank(this.resourceId)) {
                throw new RuntimeException("HttpResourceEntity resourceId is null.");
            }
            if (StringUtils.isBlank(this.resourceName)) {
                throw new RuntimeException("HttpResourceEntity resourceName is null.");
            }
            if (StringUtils.isBlank(this.uri)) {
                throw new RuntimeException("HttpResourceEntity uri is null.");
            }
            if (StringUtils.isBlank(this.param)) {
                throw new RuntimeException("HttpResourceEntity param is null.");
            }
            return new HttpResourceEntity(this);
        }
    }
}

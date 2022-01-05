package com.yb.pipeline.dal.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
@Data
public class DataMappingRuleEntity extends BaseEntity {
    private static final long serialVersionUID = 4463984148909257015L;
    private long id;
    private String sourceField;
    private String targetField;

    public DataMappingRuleEntity(Builder builder) {
        this.id = builder.id;
        this.sourceField = builder.sourceField;
        this.targetField = builder.targetField;
        this.resourceId = builder.resourceId;
        this.resourceName = builder.resourceName;
        this.status = builder.status;
        this.gmtCreate = builder.gmtCreate;
        this.gmtModified = builder.gmtModified;
    }

    public static DataMappingRuleEntity.Builder builder() {
        return new DataMappingRuleEntity.Builder();
    }


    public static final class Builder {
        private long id;
        private String sourceField;
        private String targetField;;
        private String resourceId;
        private String resourceName;
        private byte status;
        private long gmtCreate;
        private long gmtModified;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder sourceField(String sourceField) {
            this.sourceField = sourceField;
            return this;
        }

        public Builder targetField(String targetField) {
            this.targetField = targetField;
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

        public DataMappingRuleEntity build() {
            if (StringUtils.isBlank(this.sourceField)) {
                throw new RuntimeException("DataMappingRuleEntity sourceField is null.");
            }
            if (StringUtils.isBlank(this.targetField)) {
                throw new RuntimeException("DataMappingRuleEntity targetField is null.");
            }
            return new DataMappingRuleEntity(this);
        }
    }
}

package com.yb.datapipeline.context;

import com.yb.datapipeline.base.BaseContext;
import lombok.Data;

@Data
public class DataMappingRuleContext extends BaseContext {
    private String resourceId;
    private String resourceName;
    private String sourceField;
    private String targetField;
}

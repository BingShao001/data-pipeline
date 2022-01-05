package com.yb.datapipeline.context;

import com.yb.datapipeline.base.BaseContext;
import lombok.Data;

@Data
public class SyncDataJobContext extends BaseContext {
    private String resourceId;
    private String resourceName;
    private Byte jobType;
    private String jobCron;
    private Byte jobStatus;
}

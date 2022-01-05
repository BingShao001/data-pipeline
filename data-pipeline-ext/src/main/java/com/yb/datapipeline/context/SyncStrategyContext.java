package com.yb.datapipeline.context;

import com.yb.datapipeline.base.BaseContext;
import lombok.Data;

@Data
public class SyncStrategyContext extends BaseContext {
    private String resourceId;
}

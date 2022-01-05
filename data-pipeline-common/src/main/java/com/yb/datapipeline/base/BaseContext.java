package com.yb.datapipeline.base;

import lombok.Data;

@Data
public class BaseContext {
    private String bizCode;
    private String subCode;
    private String contextId;
}

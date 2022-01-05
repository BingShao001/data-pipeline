package com.yb.datapipeline.context;


import com.yb.datapipeline.base.BaseContext;
import lombok.Data;

import java.util.Map;

@Data
public class WestDataHttpSourceContext extends BaseContext {
    private String resourceId;
    private String resourceName;
    private String httpUri;
    private String httpMethod;
    private Map<String,Object> httpParam;
}

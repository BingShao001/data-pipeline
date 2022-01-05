package com.yb.datapipeline.ext;


import com.yb.datapipeline.base.BaseExt;
import com.yb.datapipeline.context.WestDataHttpSourceContext;
import com.yb.datapipeline.dto.WestDataHttpSourceDTO;

public abstract class WestDataHttpSourceExt extends BaseExt {

    public abstract void validateSource(WestDataHttpSourceContext westDataHttpSourceContext);
    public abstract void saveSource(WestDataHttpSourceContext westDataHttpSourceContext);
    public abstract WestDataHttpSourceDTO getHttpSource(String sourceId);
}

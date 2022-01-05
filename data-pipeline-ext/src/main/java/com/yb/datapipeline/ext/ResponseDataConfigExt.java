package com.yb.datapipeline.ext;


import com.yb.datapipeline.base.BaseExt;
import com.yb.datapipeline.context.ResponseDataConfigContext;
import com.yb.datapipeline.dto.ResponseDataConfigDTO;

public abstract class ResponseDataConfigExt extends BaseExt {

    public abstract void validateResponseDataConfig(ResponseDataConfigContext responseDataConfigContext);

    public abstract void saveResponseDataConfig(ResponseDataConfigContext responseDataConfigContext);

    public abstract ResponseDataConfigDTO getResponseDataConfigInfo(String resourceId);


}

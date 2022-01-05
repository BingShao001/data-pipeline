package com.yb.datapipeline.apaas;


import com.yb.datapipeline.annotition.ExtComponent;
import com.yb.datapipeline.context.ResponseDataConfigContext;
import com.yb.datapipeline.dto.ResponseDataConfigDTO;
import com.yb.datapipeline.ext.ResponseDataConfigExt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtComponent(bizCode = "aPaaS")
public class APaaSResponseDataConfigExt extends ResponseDataConfigExt {
    @Override
    public void validateResponseDataConfig(ResponseDataConfigContext responseDataConfigContext) {
        log.info("APaaSResponseDataConfigExt-validateResponseDataConfig");

    }

    @Override
    public void saveResponseDataConfig(ResponseDataConfigContext responseDataConfigContext) {
        log.info("APaaSResponseDataConfigExt-saveResponseDataConfig");
    }

    @Override
    public ResponseDataConfigDTO getResponseDataConfigInfo(String resourceId) {
        return null;
    }
}

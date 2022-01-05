package com.yb.datapipeline.apaas;


import com.yb.datapipeline.annotition.Ext;
import com.yb.datapipeline.context.WestDataHttpSourceContext;
import com.yb.datapipeline.dto.WestDataHttpSourceDTO;
import com.yb.datapipeline.ext.WestDataHttpSourceExt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@ExtComponent(bizCode = "aPaaS")
@Ext(bizCode = "aPaaS")
public class APaaSWestDataHttpSourceExt extends WestDataHttpSourceExt {

    @Override
    public void validateSource(WestDataHttpSourceContext westDataHttpSourceContext) {
        log.info("APaaSEastDataHttpSourceExt-validateSource");
    }

    @Override
    public void saveSource(WestDataHttpSourceContext westDataHttpSourceContext) {
        log.info("APaaSEastDataHttpSourceExt-saveSource");

    }

    @Override
    public WestDataHttpSourceDTO getHttpSource(String sourceId) {
        return null;
    }
}

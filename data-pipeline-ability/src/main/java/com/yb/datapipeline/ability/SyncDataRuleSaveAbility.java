package com.yb.datapipeline.ability;


import com.yb.datapipeline.component.ExtContainer;
import com.yb.datapipeline.context.DataTempleContext;
import com.yb.datapipeline.context.ResponseDataConfigContext;
import com.yb.datapipeline.context.SyncStrategyContext;
import com.yb.datapipeline.context.WestDataHttpSourceContext;
import com.yb.datapipeline.ext.DataTempleExt;
import com.yb.datapipeline.ext.ResponseDataConfigExt;
import com.yb.datapipeline.ext.SyncStrategyExt;
import com.yb.datapipeline.ext.WestDataHttpSourceExt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SyncDataRuleSaveAbility {
    @Resource
    private ExtContainer extContainer;

    public void saveRequestSource(WestDataHttpSourceContext westDataHttpSourceContext) {
        WestDataHttpSourceExt westDataHttpSourceExt = extContainer.getExt(westDataHttpSourceContext, WestDataHttpSourceExt.class);
        westDataHttpSourceExt.validateSource(westDataHttpSourceContext);
        westDataHttpSourceExt.saveSource(westDataHttpSourceContext);
    }

    public void bindingDataTemple(DataTempleContext dataTempleContext) {
        DataTempleExt dataTempleExt = extContainer.getExt(dataTempleContext, DataTempleExt.class);
        dataTempleExt.validateDataTemple(dataTempleContext);
        dataTempleExt.saveBindingDataTemple(dataTempleContext);
    }

    public void saveResponseData(ResponseDataConfigContext responseDataConfigContext) {
        ResponseDataConfigExt responseDataConfigExt = extContainer.getExt(responseDataConfigContext, ResponseDataConfigExt.class);
        responseDataConfigExt.validateResponseDataConfig(responseDataConfigContext);
        responseDataConfigExt.saveResponseDataConfig(responseDataConfigContext);
    }

    public void saveSyncStrategy(SyncStrategyContext syncStrategyContext) {
        SyncStrategyExt syncStrategyExt = extContainer.getExt(syncStrategyContext, SyncStrategyExt.class);
        syncStrategyExt.validateSyncStrategy(syncStrategyContext);
        syncStrategyExt.saveSyncStrategy(syncStrategyContext);
    }

}

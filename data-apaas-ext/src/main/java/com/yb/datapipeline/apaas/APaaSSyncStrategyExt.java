package com.yb.datapipeline.apaas;


import com.yb.datapipeline.annotition.ExtComponent;

import com.yb.datapipeline.context.SyncStrategyContext;
import com.yb.datapipeline.ext.SyncStrategyExt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtComponent(bizCode = "aPaaS")
public class APaaSSyncStrategyExt extends SyncStrategyExt {


    @Override
    public void validateSyncStrategy(SyncStrategyContext syncStrategyContext) {
        log.info("APaaSSyncStrategyExt-validateSyncStrategy");

    }

    @Override
    public void saveSyncStrategy(SyncStrategyContext syncStrategyContext) {
        log.info("APaaSSyncStrategyExt-saveSyncStrategy");

    }
}

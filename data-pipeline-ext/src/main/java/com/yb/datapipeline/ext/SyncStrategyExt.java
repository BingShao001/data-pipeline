package com.yb.datapipeline.ext;


import com.yb.datapipeline.base.BaseExt;
import com.yb.datapipeline.context.SyncStrategyContext;

public abstract class SyncStrategyExt extends BaseExt {

    public abstract void validateSyncStrategy(SyncStrategyContext syncStrategyContext);

    public abstract void saveSyncStrategy(SyncStrategyContext syncStrategyContext);
}

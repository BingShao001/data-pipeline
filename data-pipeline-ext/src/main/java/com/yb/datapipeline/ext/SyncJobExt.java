package com.yb.datapipeline.ext;


import com.yb.datapipeline.base.BaseExt;
import com.yb.datapipeline.context.SyncDataJobContext;

public abstract class SyncJobExt extends BaseExt {

    public abstract void saveJob(SyncDataJobContext syncDataJobContext);
    public abstract void validateJob(SyncDataJobContext syncDataJobContext);
    public abstract void getJobInfo();

}

package com.yb.datapipeline.ext.def;

import com.yb.datapipeline.annotition.Ext;
import com.yb.datapipeline.constants.BaseConstants;
import com.yb.datapipeline.context.SyncDataJobContext;
import com.yb.datapipeline.enums.StatusEnum;
import com.yb.datapipeline.ext.SyncJobExt;
import com.yb.datapipeline.utils.CalendarUtil;
import com.yb.pipeline.dal.entity.JobEntity;
import com.yb.pipeline.dal.repository.JobMapper;

import javax.annotation.Resource;

@Ext(bizCode = BaseConstants.DEF)
public class DefSyncJobExt extends SyncJobExt {
    @Resource
    private JobMapper jobMapper;

    @Override
    public void validateJob(SyncDataJobContext syncDataJobContext){

    }

    @Override
    public void getJobInfo() {

    }
    @Override
    public void saveJob(SyncDataJobContext syncDataJobContext){
        JobEntity jobEntity = JobEntity.builder()
                .resourceId(syncDataJobContext.getResourceId())
                .resourceName(syncDataJobContext.getResourceName())
                .jobStatus((byte) 1)
                .jobType((byte) 1)
                .jobCron(syncDataJobContext.getJobCron())
                .status(StatusEnum.INVALID.getCode())
                .gmtCreate(CalendarUtil.getNowTime())
                .gmtModified(CalendarUtil.getNowTime())
                .build();
        jobMapper.save(jobEntity);
    }
}

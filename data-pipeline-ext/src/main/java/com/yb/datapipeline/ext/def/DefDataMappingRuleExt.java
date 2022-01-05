package com.yb.datapipeline.ext.def;

import com.yb.datapipeline.annotition.Ext;
import com.yb.datapipeline.constants.BaseConstants;
import com.yb.datapipeline.context.DataMappingRuleContext;
import com.yb.datapipeline.enums.StatusEnum;
import com.yb.datapipeline.ext.DataMappingRuleExt;
import com.yb.datapipeline.utils.CalendarUtil;
import com.yb.pipeline.dal.entity.DataMappingRuleEntity;
import com.yb.pipeline.dal.repository.DataMappingRuleMapper;

import javax.annotation.Resource;

@Ext(bizCode = BaseConstants.DEF)
public class DefDataMappingRuleExt extends DataMappingRuleExt {
    @Resource
    private DataMappingRuleMapper dataMappingRuleMapper;
    @Override
    public void validateDataMappingRule(DataMappingRuleContext dataMappingRuleContext) {

    }

    @Override
    public void saveDataMappingRule(DataMappingRuleContext dataMappingRuleContext) {
        DataMappingRuleEntity dataMappingRuleEntity = DataMappingRuleEntity.builder()
                .resourceId(dataMappingRuleContext.getResourceId())
                .resourceName(dataMappingRuleContext.getResourceName())
                .sourceField(dataMappingRuleContext.getSourceField())
                .targetField(dataMappingRuleContext.getTargetField())
                .status(StatusEnum.VALID.getCode())
                .gmtCreate(CalendarUtil.getNowTime())
                .gmtModified(CalendarUtil.getNowTime())
                .build();
        dataMappingRuleMapper.save(dataMappingRuleEntity);
    }
}

package com.yb.datapipeline.ext;


import com.yb.datapipeline.base.BaseExt;
import com.yb.datapipeline.context.DataMappingRuleContext;
import com.yb.datapipeline.context.DataTempleContext;

public abstract class DataMappingRuleExt extends BaseExt {

    public abstract void validateDataMappingRule(DataMappingRuleContext dataMappingRuleContext);

    public abstract void saveDataMappingRule(DataMappingRuleContext dataMappingRuleContext);
}

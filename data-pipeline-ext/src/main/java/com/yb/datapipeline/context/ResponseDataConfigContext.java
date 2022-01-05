package com.yb.datapipeline.context;

import com.yb.datapipeline.base.BaseContext;
import com.yb.datapipeline.model.DataMapRuleModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDataConfigContext extends BaseContext {
    private String contextId;
    private List<DataMapRuleModel> dataMapRuleModels;
}

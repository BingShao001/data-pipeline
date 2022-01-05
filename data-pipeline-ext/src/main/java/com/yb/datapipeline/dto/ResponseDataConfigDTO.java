package com.yb.datapipeline.dto;

import com.yb.datapipeline.model.DataMapRuleModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDataConfigDTO {
    private String resourceId;
    private List<DataMapRuleModel> dataMapRuleModels;
}

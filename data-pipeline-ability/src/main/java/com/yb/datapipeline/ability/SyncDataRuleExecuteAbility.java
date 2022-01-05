package com.yb.datapipeline.ability;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import com.yb.datapipeline.component.ExtContainer;
import com.yb.datapipeline.utils.HttpClientUtils;
import com.yb.datapipeline.context.WestDataHttpSourceContext;
import com.yb.datapipeline.dto.ResponseDataConfigDTO;
import com.yb.datapipeline.dto.WestDataHttpSourceDTO;
import com.yb.datapipeline.enums.HttpMethodEnum;
import com.yb.datapipeline.ext.EastDataExt;
import com.yb.datapipeline.ext.ResponseDataConfigExt;
import com.yb.datapipeline.ext.WestDataHttpSourceExt;
import com.yb.datapipeline.model.DataMapRuleModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class SyncDataRuleExecuteAbility {
    @Resource
    private ExtContainer extContainer;

    public void executeSyncData(WestDataHttpSourceContext westDataHttpSourceContext) {
        WestDataHttpSourceExt westDataHttpSourceExt = extContainer.getExt(westDataHttpSourceContext, WestDataHttpSourceExt.class);
        WestDataHttpSourceDTO westDataHttpSourceDTO = westDataHttpSourceExt.getHttpSource(null);
        String westResult = this.doHttpRequest(westDataHttpSourceDTO);
        ResponseDataConfigExt responseDataConfigExt = extContainer.getExt(westDataHttpSourceContext, ResponseDataConfigExt.class);
        ResponseDataConfigDTO responseDataConfigInfo = responseDataConfigExt.getResponseDataConfigInfo(null);
        Map<String, String> eastMap = this.parseData(westResult, responseDataConfigInfo);
        EastDataExt eastDataExt = extContainer.getExt(westDataHttpSourceContext, EastDataExt.class);
        eastDataExt.saveEastData(eastMap);
    }

    private String doHttpRequest(WestDataHttpSourceDTO westDataHttpSourceDTO) {
        String httpMethod = westDataHttpSourceDTO.getHttpMethod();
        String result = null;
        if (HttpMethodEnum.GET.getValue().equals(httpMethod)) {
            result = HttpClientUtils.doGet(westDataHttpSourceDTO.getHttpUri(), westDataHttpSourceDTO.getHttpParam());
        }
        if (HttpMethodEnum.POST.getValue().equals(httpMethod)) {
            try {
                result = HttpClientUtils.doPost(westDataHttpSourceDTO.getHttpUri(), westDataHttpSourceDTO.getHttpParam());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Map<String, String> parseData(String westResult, ResponseDataConfigDTO responseDataConfigInfo) {
        JSONObject westJson = JSON.parseObject(westResult, JSONObject.class);
        List<DataMapRuleModel> dataMapRuleModels = responseDataConfigInfo.getDataMapRuleModels();
        Map<String, String> eastMap = Maps.newHashMap();
        for (DataMapRuleModel dataMapRuleModel : dataMapRuleModels) {
            String westKey = dataMapRuleModel.getWestKey();
            String eastKey = dataMapRuleModel.getEastKey();
            String value = westJson.getString(westKey);
            eastMap.put(eastKey,value);
        }
        return eastMap;

    }

}

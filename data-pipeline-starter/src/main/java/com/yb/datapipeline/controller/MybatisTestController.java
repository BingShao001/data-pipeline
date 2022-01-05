package com.yb.datapipeline.controller;

import com.google.common.collect.Maps;
import com.yb.datapipeline.component.ExtContainer;
import com.yb.datapipeline.context.DataMappingRuleContext;
import com.yb.datapipeline.context.SyncDataJobContext;
import com.yb.datapipeline.context.WestDataHttpSourceContext;
import com.yb.datapipeline.enums.HttpMethodEnum;
import com.yb.datapipeline.ext.DataMappingRuleExt;
import com.yb.datapipeline.ext.SyncJobExt;
import com.yb.datapipeline.ext.WestDataHttpSourceExt;
import com.yb.datapipeline.ext.def.DefWestDataHttpSourceExt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/mybatis")
public class MybatisTestController {
    @Resource
    private ExtContainer extContainer;
    @Resource
    private DefWestDataHttpSourceExt defWestDataHttpSourceExt;

    @RequestMapping("/saveHttp")
    public void saveHttp(){
        WestDataHttpSourceExt defWestDataHttpSourceExt = extContainer.getDefExt(WestDataHttpSourceExt.class);
        Map<String,Object> httpParam = Maps.newHashMap();
        httpParam.put("a",5);
        httpParam.put("b","30");
        WestDataHttpSourceContext westDataHttpSourceContext = new WestDataHttpSourceContext();
        westDataHttpSourceContext.setContextId(String.valueOf(System.currentTimeMillis()));
        westDataHttpSourceContext.setHttpUri("www.baidu.com");
        westDataHttpSourceContext.setHttpMethod(HttpMethodEnum.GET.getValue());
        westDataHttpSourceContext.setHttpParam(httpParam);
        westDataHttpSourceContext.setResourceId("http_db_test_01");
        westDataHttpSourceContext.setResourceName("bing_test_mybatis");
        defWestDataHttpSourceExt.saveSource(westDataHttpSourceContext);
    }
    @RequestMapping("/saveJob")
    public void saveJob(){
        SyncJobExt defSyncJobExt = extContainer.getDefExt(SyncJobExt.class);
        SyncDataJobContext syncDataJobContext = new SyncDataJobContext();
        syncDataJobContext.setResourceId("job_db_test_02");
        syncDataJobContext.setResourceName("bing_test_mybatis");
        syncDataJobContext.setJobCron("*/5 * * * * *");
        defSyncJobExt.saveJob(syncDataJobContext);
    }
    @RequestMapping("/saveRule")
    public void saveRule(){
        DataMappingRuleExt defDataMappingRuleExt = extContainer.getDefExt(DataMappingRuleExt.class);
        DataMappingRuleContext dataMappingRuleContext = new DataMappingRuleContext();
        dataMappingRuleContext.setResourceId("rule_db_test_03");
        dataMappingRuleContext.setResourceName("bing_test_mybatis");
        dataMappingRuleContext.setSourceField("data.people");
        dataMappingRuleContext.setTargetField("data.person");
        defDataMappingRuleExt.saveDataMappingRule(dataMappingRuleContext);
    }
}

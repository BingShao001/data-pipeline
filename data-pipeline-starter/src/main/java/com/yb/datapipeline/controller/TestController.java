package com.yb.datapipeline.controller;

import com.yb.datapipeline.ability.SyncDataRuleSaveAbility;
import com.yb.datapipeline.context.DataTempleContext;
import com.yb.datapipeline.context.ResponseDataConfigContext;
import com.yb.datapipeline.context.SyncStrategyContext;
import com.yb.datapipeline.context.WestDataHttpSourceContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ext")
public class TestController {
    @Resource
    private SyncDataRuleSaveAbility syncDataRuleSaveAbility;
    @RequestMapping("/save")
    public void test(){
        String bizCode = "aPaaS";
        WestDataHttpSourceContext westDataHttpSourceContext = new WestDataHttpSourceContext();
        westDataHttpSourceContext.setBizCode(bizCode);
        syncDataRuleSaveAbility.saveRequestSource(westDataHttpSourceContext);
        DataTempleContext dataTempleContext = new DataTempleContext();
        dataTempleContext.setBizCode(bizCode);
        syncDataRuleSaveAbility.bindingDataTemple(dataTempleContext);
        ResponseDataConfigContext responseDataConfigContext = new ResponseDataConfigContext();
        responseDataConfigContext.setBizCode(bizCode);
        syncDataRuleSaveAbility.saveResponseData(responseDataConfigContext);
        SyncStrategyContext syncStrategyContext = new SyncStrategyContext();
        syncStrategyContext.setBizCode(bizCode);
        syncDataRuleSaveAbility.saveSyncStrategy(syncStrategyContext);
    }
}

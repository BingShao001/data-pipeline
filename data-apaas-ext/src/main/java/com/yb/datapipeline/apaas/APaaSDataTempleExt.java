package com.yb.datapipeline.apaas;


import com.yb.datapipeline.annotition.Ext;
import com.yb.datapipeline.context.DataTempleContext;
import com.yb.datapipeline.ext.DataTempleExt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@ExtComponent(bizCode = "aPaaS")
@Ext(bizCode = "aPaaS")
public class APaaSDataTempleExt extends DataTempleExt {
    @Override
    public void validateDataTemple(DataTempleContext dataTempleContext) {
        log.info("APaaSDataTempleExt-validateDataTemple");
    }

    @Override
    public void saveBindingDataTemple(DataTempleContext dataTempleContext) {
        log.info("APaaSDataTempleExt-saveBindingDataTemple");
    }
}

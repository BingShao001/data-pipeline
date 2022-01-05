package com.yb.datapipeline.component;


import com.google.common.collect.Maps;
import com.yb.datapipeline.base.BaseContext;
import com.yb.datapipeline.base.BaseExt;
import com.yb.datapipeline.enums.ValidateEnum;
import com.yb.datapipeline.exception.OriginalAssert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.yb.datapipeline.constants.BaseConstants.DEF;
import static com.yb.datapipeline.constants.BaseConstants.UNDERLINE;

@Component
public class ExtContainer {
    private Map<String, BaseExt> extContainerMap = Maps.newConcurrentMap();

    public Map<String, BaseExt> addExt(String key, BaseExt baseExt) {
        extContainerMap.put(key, baseExt);
        return extContainerMap;
    }

    public <T> T getExt(BaseContext baseContext, Class<T> tClass) {
        String bizCode = baseContext.getBizCode();
        String subCode = baseContext.getSubCode();
        return StringUtils.isBlank(subCode) ? getExt(bizCode, tClass) : getExt(bizCode, subCode, tClass);
    }

    private <T> T getExt(String bizCode, Class<T> tClass) {
        String simpleName = tClass.getSimpleName();
        String key = new StringBuilder(simpleName)
                .append(UNDERLINE)
                .append(bizCode)
                .append(UNDERLINE)
                .append(DEF)
                .toString();
        T t = (T) extContainerMap.get(key);
        OriginalAssert.isRealNull(t, ValidateEnum.EXT_CONTAINER_ERROR, key);
        return t;
    }

    private <T> T getExt(String bizCode, String subCode, Class<T> tClass) {
        String simpleName = tClass.getSimpleName();
        String key = new StringBuilder(simpleName)
                .append(UNDERLINE)
                .append(bizCode)
                .append(UNDERLINE)
                .append(subCode)
                .toString();
        T t = (T) extContainerMap.get(key);
        OriginalAssert.isRealNull(t, ValidateEnum.EXT_CONTAINER_ERROR, key);
        return t;
    }

    public <T> T getDefExt(Class<T> tClass) {
        return this.getExt(DEF, tClass);
    }
}

package com.yb.datapipeline.ext.def;

import com.alibaba.fastjson.JSON;
import com.yb.datapipeline.annotition.Ext;
import com.yb.datapipeline.constants.BaseConstants;
import com.yb.datapipeline.context.WestDataHttpSourceContext;
import com.yb.datapipeline.dto.WestDataHttpSourceDTO;
import com.yb.datapipeline.enums.HttpMethodEnum;
import com.yb.datapipeline.enums.StatusEnum;
import com.yb.datapipeline.ext.WestDataHttpSourceExt;
import com.yb.datapipeline.utils.CalendarUtil;
import com.yb.pipeline.dal.entity.HttpResourceEntity;
import com.yb.pipeline.dal.repository.HttpResourceMapper;

import javax.annotation.Resource;

@Ext(bizCode = BaseConstants.DEF)
public class DefWestDataHttpSourceExt extends WestDataHttpSourceExt {
    @Resource
    private HttpResourceMapper httpResourceMapper;

    @Override
    public void validateSource(WestDataHttpSourceContext westDataHttpSourceContext) {

    }

    @Override
    public void saveSource(WestDataHttpSourceContext westDataHttpSourceContext) {

        HttpResourceEntity httpResourceEntity = HttpResourceEntity.builder()
                .resourceId(westDataHttpSourceContext.getResourceId())
                .resourceName(westDataHttpSourceContext.getResourceName())
                .uri(westDataHttpSourceContext.getHttpUri())
                .httpType(HttpMethodEnum.convert2code(westDataHttpSourceContext.getHttpMethod()))
                .param(JSON.toJSONString(westDataHttpSourceContext.getHttpParam()))
                .status(StatusEnum.INVALID.getCode())
                .gmtCreate(CalendarUtil.getNowTime())
                .gmtModified(CalendarUtil.getNowTime())
                .build();
        httpResourceMapper.save(httpResourceEntity);
    }

    @Override
    public WestDataHttpSourceDTO getHttpSource(String sourceId) {
        return null;
    }
}

package com.yb.pipeline.dal.repository;

import com.yb.pipeline.dal.entity.HttpResourceEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HttpResourceMapper {

     int save(HttpResourceEntity httpResourceEntity);
}

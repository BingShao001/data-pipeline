package com.yb.pipeline.dal.repository;

import com.yb.pipeline.dal.entity.JobEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobMapper {

     int save(JobEntity jobEntity);
}

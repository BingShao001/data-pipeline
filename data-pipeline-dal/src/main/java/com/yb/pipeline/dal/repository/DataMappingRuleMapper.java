package com.yb.pipeline.dal.repository;

import com.yb.pipeline.dal.entity.DataMappingRuleEntity;
import com.yb.pipeline.dal.entity.JobEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DataMappingRuleMapper {
    @Insert("insert into data_pipeline_data_mapping_rule" +
            "  (`resource_id`,`resource_name`,`source_field`,`target_field`,`status`,`gmt_create`,`gmt_modified`)" +
            "  values (#{resourceId},#{resourceName},#{sourceField},#{targetField},#{status},#{gmtCreate},#{gmtModified})")
    int save(DataMappingRuleEntity dataMappingRuleEntity);
}

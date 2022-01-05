package com.yb.datapipeline.ext;



import com.yb.datapipeline.base.BaseExt;

import java.util.Map;

public abstract class EastDataExt extends BaseExt {

    public abstract void saveEastData(Map<String,String> eastMapData);
}

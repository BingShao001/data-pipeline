package com.yb.datapipeline.ext;


import com.yb.datapipeline.base.BaseExt;
import com.yb.datapipeline.context.DataTempleContext;

public abstract class DataTempleExt extends BaseExt {

    public abstract void validateDataTemple(DataTempleContext dataTempleContext);

    public abstract void saveBindingDataTemple(DataTempleContext dataTempleContext);
}

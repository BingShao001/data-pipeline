package com.yb.datapipeline.exception;


import com.yb.datapipeline.enums.ValidateEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 断言扩展自定义
 *
 * @author bing
 * @version 1.0
 * @create 2018/5/23
 **/
public class OriginalAssert extends Assert {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(OriginalAssert.class);

    /***
     * 当出入的逻辑判断为true时抛出异常符合中国人思维
     * @param expression 逻辑表达
     * @param msg 提示properties对应的key
     * @throws DataPipelineException 提示异常标识
     */
    public static void isRealTrueThrows(boolean expression, int errorCode, String msg) throws DataPipelineException {
        if (expression) {
            throw new DataPipelineException(errorCode, msg);
        }
    }

    /***
     * 当出入的逻辑判断为true时抛出异常符合中国人思维
     * @param expression 逻辑表达
     * @param validateEnum 提示枚举
     * @param extMsg
     * @throws DataPipelineException 提示异常标识
     */
    public static void isRealTrue(boolean expression, ValidateEnum validateEnum, String extMsg) throws DataPipelineException {
        if (expression) {
            throwZeliaException(validateEnum, extMsg);
        }
    }

    /***
     * 当出入的逻辑判断为false时抛出异常符合中国人思维
     * @param expression 逻辑表达
     * @param validateEnum 提示枚举
     * @param extMsg
     * @throws DataPipelineException 提示异常标识
     */
    public static void isRealFalse(boolean expression, ValidateEnum validateEnum, String extMsg) throws DataPipelineException {
        if (!expression) {
            throwZeliaException(validateEnum, extMsg);
        }
    }

    /***
     * 当出入的对象判断为null时抛出异常符合中国人思维
     * @param object 对象类型
     * @param validateEnum 提示枚举
     * @param extMsg
     * @throws DataPipelineException 提示异常标识
     */
    public static void isRealNull(Object object, ValidateEnum validateEnum, String extMsg) throws DataPipelineException {
        if (object == null) {
            throwZeliaException(validateEnum, extMsg);
        }
    }

    /***
     * 当出入的对象判断为blank时抛出异常符合中国人思维
     * @param str 字符串对象
     * @param validateEnum 提示枚举
     * @param extMsg
     * @throws DataPipelineException 提示异常标识
     */
    public static void isRealBlank(String str, ValidateEnum validateEnum, String extMsg) throws DataPipelineException {
        if (StringUtils.isBlank(str)) {
            throwZeliaException(validateEnum, extMsg);
        }
    }

    /***
     * 当出入的集合判断为empty时抛出异常符合中国人思维
     * @param collection 集合框架
     * @param validateEnum 提示枚举
     * @param extMsg
     * @throws DataPipelineException 提示异常标识
     */
    public static void isEmpty(Collection<?> collection, ValidateEnum validateEnum, String extMsg) throws DataPipelineException {
        if (CollectionUtils.isEmpty(collection)) {
            throwZeliaException(validateEnum, extMsg);
        }
    }

    /***
     * 当出入的集合判断为empty时抛出异常符合中国人思维
     * @param map 集合框架
     * @param validateEnum 提示枚举
     * @param extMsg
     * @throws DataPipelineException 提示异常标识
     */
    public static void isEmpty(Map<?, ?> map, ValidateEnum validateEnum, String extMsg) throws DataPipelineException {
        if (CollectionUtils.isEmpty(map)) {
            throwZeliaException(validateEnum, extMsg);
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param string       字符串
     * @param validateEnum 提示枚举
     * @param extMsg
     * @throws DataPipelineException 提示异常标识
     */
    public static void isStringEmpty(String string, ValidateEnum validateEnum, String extMsg) throws DataPipelineException {
        if (StringUtils.isBlank(string)) {
            throwZeliaException(validateEnum, extMsg);
        }
    }

    /**
     * 记录日志并抛出业务异常
     *
     * @param validateEnum 提示枚举
     * @throws DataPipelineException 提示异常标识
     */
    public static void throwZeliaException(ValidateEnum validateEnum) throws DataPipelineException {
        throw new DataPipelineException(validateEnum.getCode(), validateEnum.getMsg());
    }

    public static void throwZeliaException(ValidateEnum validateEnum, String extMsg) throws DataPipelineException {
        throw new DataPipelineException(validateEnum.getCode(), validateEnum.getMsg() + extMsg);
    }

    public static void throwZeliaException(ValidateEnum validateEnum, String extMsg, Throwable e) throws DataPipelineException {
        throw new DataPipelineException(validateEnum.getCode(), validateEnum.getMsg() + extMsg, e);
    }
}


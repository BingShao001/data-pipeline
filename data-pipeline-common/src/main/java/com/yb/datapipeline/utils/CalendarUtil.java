package com.yb.datapipeline.utils;

import java.sql.Timestamp;

public class CalendarUtil {

    // java 时间 转php 时间 戳
    public static long java2Php(long time) {
        int length = String.valueOf(time).length();
        if (length > 11) {
            String tmp = String.valueOf(time).substring(0, 10);
            time = Long.valueOf(tmp);
        }
        return time;
    }


    /**
     * 获取当前时间戳
     */
    public static long getNowTime() {
        return getCurrentDateTime().getTime();
    }

    /**
     * 获取当前时间自动转换成10位
     *
     * @param isShort
     * @return
     */
    public static long getNowTime(Boolean isShort) {
        if (isShort) {
            return java2Php(getNowTime());
        }
        return getCurrentDateTime().getTime();
    }


    /**
     * return current time
     *
     * @return current time
     */
    public static Timestamp getCurrentDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }
}

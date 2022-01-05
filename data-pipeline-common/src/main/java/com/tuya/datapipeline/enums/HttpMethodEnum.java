package com.yb.datapipeline.enums;

import java.util.HashMap;
import java.util.Map;

public enum HttpMethodEnum {
    GET((byte) 0, "get"),
    POST((byte) 1, "post");

    private static Map<String, Byte> valueCodeMap = new HashMap<>();

    private String value;
    private Byte code;

    static {
        for (HttpMethodEnum value : HttpMethodEnum.values()) {
            valueCodeMap.put(value.getValue(), value.getCode());
        }
    }

    HttpMethodEnum(Byte code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Byte getCode() {
        return code;
    }

    public HttpMethodEnum setCode(Byte code) {
        this.code = code;
        return this;
    }

    public HttpMethodEnum setValue(String value) {
        this.value = value;
        return this;
    }

    public static Byte convert2code(String value) {
        return valueCodeMap.get(value);
    }
}

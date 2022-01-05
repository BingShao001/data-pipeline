package com.yb.datapipeline.enums;


public enum ValidateEnum {
    EXT_CONTAINER_ERROR(1001, "the container has no ext ,the key is : ");

    private int code;
    private String msg;

    private ValidateEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

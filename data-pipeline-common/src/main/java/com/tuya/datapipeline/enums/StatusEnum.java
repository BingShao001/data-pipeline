package com.yb.datapipeline.enums;

public enum StatusEnum {

    VALID((byte) 1),
    INVALID((byte) 0);
    private Byte code;

    StatusEnum(Byte code) {
        this.code = code;
    }

    public Byte getCode() {
        return code;
    }

    public StatusEnum setCode(Byte code) {
        this.code = code;
        return this;
    }
}

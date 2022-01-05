package com.yb.datapipeline.exception;


/**
 * @author bing
 * @version 1.0
 * @create 02/11/2020
 **/
public class DataPipelineException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /**
     * 默认业务错误分组
     */
    private final static String BUSSINESS_DEFAULT_ERRORGROUP = "220";
    /**
     * 错误编码
     */
    private int errCode;
    /**
     * 错误消息
     */
    private String message;
    /**
     * 业务错误分组
     */
    private String bussinessErrorGroup = BUSSINESS_DEFAULT_ERRORGROUP;


    /**
     * 构造一个分组业务异常.
     *
     * @param errCode             错误码
     * @param message             信息描述
     * @param bussinessErrorGroup 错误分组
     */
    private DataPipelineException(int errCode, String message, String bussinessErrorGroup) {
        super(errCode + " : " + message);
        this.errCode = errCode;
        this.message = message;
        this.bussinessErrorGroup = bussinessErrorGroup;
    }

    /**
     * 构造一个默认分组业务异常.
     *
     * @param errCode 错误码
     * @param message 信息描述
     */
    public DataPipelineException(int errCode, String message) {
        super(errCode + " : " + message);
        this.errCode = errCode;
        this.message = message;
    }

    public DataPipelineException(int errCode, String message, Throwable cause) {
        super(errCode + " : " + message, cause);
        this.errCode = errCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getBussinessErrorGroup() {
        return bussinessErrorGroup;
    }

    public void setBussinessErrorGroup(String bussinessErrorGroup) {
        this.bussinessErrorGroup = bussinessErrorGroup;
    }

    @Override
    public String toString() {
        return "DataPipelineException{" +
                "errorCode=" + errCode +
                ", message='" + message + '\'' +
                ", bussinessErrorGroup='" + bussinessErrorGroup + '\'' +
                '}';
    }
}

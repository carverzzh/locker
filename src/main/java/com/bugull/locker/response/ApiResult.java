package com.bugull.locker.response;

import java.io.Serializable;

/**
 * @program: locker
 * @description: 响应结果
 * @author: Carver Zhang
 * @create: 2019-06-05 09:05
 **/
public class ApiResult<T> implements Serializable {

    public static final int SUCCESS = 1;

    public static final int ERROR = 0;

    /**
     * 响应结果码 1：成功，0：失败
     */
    private Integer code;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应错误信息
     */
    private String errorMsg;

    /**
     * 错误码
     */
    private String errorCode;

    public ApiResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public static <E> ApiResult<E> success(E e) {
        ApiResult result = new ApiResult();
        result.setCode(SUCCESS);
        result.setData(e);
        return result;
    }

    public static ApiResult error() {
        ApiResult result = new ApiResult();
        result.setCode(ERROR);
        return result;
    }

}

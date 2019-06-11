package com.bugull.locker.response.apierror.errors.common;

import com.bugull.locker.response.apierror.ApiError;

/**
 * @program: locker
 * @description: 公共错误
 * @author: Carver Zhang
 * @create: 2019-06-11 14:10
 **/
public enum COMMON implements ApiError{

    SYS_BUSY,
    PARAM_ILL
    ;

    @Override
    public String getErrorCode() {
        return this.name();
    }

    @Override
    public String getErrorMessage() {
        return this.name();
    }
}

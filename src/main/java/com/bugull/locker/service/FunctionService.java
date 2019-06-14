package com.bugull.locker.service;

import com.bugull.locker.entity.FunctionEntity;

public interface FunctionService extends BaseService {

    public FunctionEntity deleteByUser(String id, String userId);

    public boolean checkFunctionExist(String functionName, String functionCode, String menuId);
}

package com.bugull.locker.dao;

import com.bugull.locker.entity.FunctionEntity;
import com.bugull.locker.entity.MenuEntity;

public interface FunctionDao extends BaseDAO{

    public FunctionEntity deleteByUser(String id, String userId);

    public boolean checkFunctionExist(String functionName, String functionCode, String menuId);
}

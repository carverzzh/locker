package com.bugull.locker.service.impl;

import com.bugull.locker.dao.BaseDAO;
import com.bugull.locker.dao.FunctionDao;
import com.bugull.locker.entity.FunctionEntity;
import com.bugull.locker.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: locker
 * @description: 功能管理
 * @author: Carver Zhang
 * @create: 2019-06-13 14:10
 **/
@Service
public class FunctionServiceImpl extends BaseServiceImpl implements FunctionService{

    @Autowired
    private FunctionDao functionDao;

    @Override
    protected BaseDAO getBaseDao() {
        return functionDao;
    }

    @Override
    public Class<?> getEntityClass() {
        return FunctionEntity.class;
    }

    @Override
    public FunctionEntity deleteByUser(String id, String userId) {
        return functionDao.deleteByUser(id, userId);
    }

    @Override
    public boolean checkFunctionExist(String functionName, String functionCode, String menuId) {
        return functionDao.checkFunctionExist(functionName, functionCode, menuId);
    }
}

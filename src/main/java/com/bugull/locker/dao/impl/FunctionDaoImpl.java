package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.FunctionDao;
import com.bugull.locker.entity.FunctionEntity;
import com.bugull.locker.mapper.FunctionMapper;
import org.springframework.stereotype.Service;

/**
 * @program: locker
 * @description: 功能管理
 * @author: Carver Zhang
 * @create: 2019-06-12 13:47
 **/
@Service
public class FunctionDaoImpl extends BaseDAOImpl implements FunctionDao{

    @Override
    public Class<?> getEntityClass() {
        return FunctionEntity.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return FunctionMapper.class;
    }

    @Override
    public FunctionEntity deleteByUser(String id, String userId) {
        FunctionEntity result = null;
        FunctionMapper map = (FunctionMapper) sqlSession.getMapper(getMapperClass());
        result = (FunctionEntity) selectById(id);
        map.deleteByUser(id, userId);
        return result;
    }

    @Override
    public boolean checkFunctionExist(String functionName, String functionCode, String menuId) {
        FunctionMapper map = (FunctionMapper) sqlSession.getMapper(getMapperClass());
        Integer check = map.checkFunctionExist(functionName, functionCode, menuId);
        if (check != null && check == 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}

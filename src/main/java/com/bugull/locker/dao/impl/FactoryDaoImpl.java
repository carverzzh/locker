package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.FactoryDao;
import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.FactoryEntity;
import com.bugull.locker.mapper.BaseMapper;
import com.bugull.locker.mapper.FactoryMapper;
import org.springframework.stereotype.Service;


/**
 * @program: locker
 * @description: 工厂管理
 * @author: Carver Zhang
 * @create: 2019-06-11 13:22
 **/
@Service
public class FactoryDaoImpl extends BaseDAOImpl implements FactoryDao{

    @Override
    public Class<?> getEntityClass() {
        return FactoryEntity.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return FactoryMapper.class;
    }

    @Override
    public FactoryEntity deleteByUser(String id, String userId) {
        FactoryEntity result = null;
        FactoryMapper map = (FactoryMapper) sqlSession.getMapper(getMapperClass());
        result = (FactoryEntity) selectById(id);
        map.deleteByUser(id, userId);
        return result;
    }

    @Override
    public boolean checkFacExist(String factoryName, String factoryCode) {
        FactoryMapper map = (FactoryMapper) sqlSession.getMapper(getMapperClass());
        Integer check = map.checkFacExist(factoryName, factoryCode);
        if (check != null && check == 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}

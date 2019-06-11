package com.bugull.locker.service.impl;

import com.bugull.locker.dao.BaseDAO;
import com.bugull.locker.dao.FactoryDao;
import com.bugull.locker.entity.FactoryEntity;
import com.bugull.locker.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: locker
 * @description: 工厂管理
 * @author: Carver Zhang
 * @create: 2019-06-11 13:58
 **/
@Service
public class FactoryServiceImpl extends BaseServiceImpl implements FactoryService {

    @Autowired
    private FactoryDao factoryDao;

    @Override
    protected BaseDAO getBaseDao() {
        return factoryDao;
    }

    @Override
    public Class<?> getEntityClass() {
        return FactoryEntity.class;
    }

    @Override
    public FactoryEntity deleteByUser(String id, String userId) {
        return factoryDao.deleteByUser(id, userId);
    }

    @Override
    public boolean checkFacExist(String factoryName, String factoryCode) {
        return factoryDao.checkFacExist(factoryName, factoryCode);
    }
}

package com.bugull.locker.dao;

import com.bugull.locker.entity.FactoryEntity;

public interface FactoryDao extends BaseDAO {

    public FactoryEntity deleteByUser(String id, String userId);

    public boolean checkFacExist(String factoryName, String factoryCode);
}

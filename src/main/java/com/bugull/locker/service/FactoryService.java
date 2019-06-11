package com.bugull.locker.service;

import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.FactoryEntity;
import com.bugull.locker.service.BaseService;

public interface FactoryService extends BaseService {

    public FactoryEntity deleteByUser(String id, String userId);

    public boolean checkFacExist(String factoryName, String factoryCode);
}

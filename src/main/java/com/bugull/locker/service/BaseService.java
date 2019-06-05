package com.bugull.locker.service;

import com.bugull.locker.entity.BaseEntity;

import java.util.List;
import java.util.Map;

public abstract interface BaseService {

    public abstract BaseEntity selectById(String id);

    public abstract List<BaseEntity> selectByIds(List<String> ids);

    public abstract void deleteById(String id);

    public abstract void deleteByIds(List<String> ids);

    public abstract void insertEntity(BaseEntity entity);

    public abstract void updateEntity(BaseEntity entity);

    public abstract List<BaseEntity> selectPageByMap(Map<String, Object> map, int pageNum, int pageSize);
}

package com.bugull.locker.dao;

import com.bugull.locker.entity.BaseEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public abstract interface BaseDAO {

    public abstract BaseEntity selectById(String id);

    public abstract List<BaseEntity> selectByIds(List<String> ids);

    public abstract BaseEntity deleteById(String id);

    public abstract List<BaseEntity> deleteByIds(List<String> ids);

    public abstract BaseEntity insertEntity(BaseEntity entity);

    public abstract BaseEntity updateEntity(BaseEntity entity);

    public abstract PageInfo<BaseEntity> selectPageByMap(Map<String, Object> params, int pageNum, int pageSize);

    public abstract Class<?> getEntityClass();

    public abstract Class<?> getMapperClass();
}

package com.bugull.locker.service;

import com.bugull.locker.entity.BaseEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public abstract interface BaseService {

    public abstract BaseEntity selectById(BaseEntity entity);

    public abstract List<BaseEntity> selectByIds(List<BaseEntity> paramList);

    public abstract BaseEntity deleteById(BaseEntity entity);

    public abstract List<BaseEntity> deleteByIds(List<BaseEntity> entitys);

    public abstract BaseEntity insertEntity(BaseEntity entity);

    public abstract BaseEntity updateEntity(BaseEntity entity);

    public abstract PageInfo<BaseEntity> selectPageByMap(Map<String, Object> params, int pageNum, int pageSize);

    public abstract Class<?> getEntityClass();
}

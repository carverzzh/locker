package com.bugull.locker.mapper;

import com.bugull.locker.entity.BaseEntity;

import java.util.List;
import java.util.Map;

public interface BaseMapper{

    public abstract BaseEntity selectById(String id);

    public abstract List<BaseEntity> selectByIds(List<String> ids);

    public abstract void deleteById(String id);

    public abstract void deleteByIds(List<String> ids);

    public abstract void insertEntity(BaseEntity entity);

    public abstract void updateEntity(BaseEntity entity);

    public abstract List<BaseEntity> selectPageByMap(Map<String, Object> map);


}

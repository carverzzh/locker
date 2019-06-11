package com.bugull.locker.service.impl;

import com.bugull.locker.dao.BaseDAO;
import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-11 13:43
 **/
public abstract class BaseServiceImpl implements BaseService {

    protected abstract BaseDAO getBaseDao();

    @Override
    public BaseEntity selectById(BaseEntity entity) {
        return getBaseDao().selectById(entity.getId());
    }

    @Override
    public List<BaseEntity> selectByIds(List<BaseEntity> entitys) {
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < entitys.size(); i++) {
            ids.add(((BaseEntity) entitys.get(i)).getId());
        }
        return getBaseDao().selectByIds(ids);
    }

    @Override
    public BaseEntity insertEntity(BaseEntity entity) {
        return getBaseDao().insertEntity(entity);
    }

    @Override
    public BaseEntity deleteById(BaseEntity entity) {
        return getBaseDao().deleteById(entity.getId());
    }

    @Override
    public List<BaseEntity> deleteByIds(List<BaseEntity> entitys) {
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < entitys.size(); i++) {
            ids.add(((BaseEntity) entitys.get(i)).getId());
        }
        return getBaseDao().deleteByIds(ids);
    }

    @Override
    public BaseEntity updateEntity(BaseEntity entity) {
        return getBaseDao().updateEntity(entity);
    }

    @Override
    public PageInfo<BaseEntity> selectPageByMap(Map<String, Object> params,
                                                int pageNo, int pageSize) {
        return getBaseDao().selectPageByMap(params, pageNo, pageSize);
    }
}

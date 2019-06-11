package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.BaseDAO;
import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.mapper.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-11 13:31
 **/
public abstract class BaseDAOImpl implements BaseDAO {

    @Autowired
    protected SqlSession sqlSession;

    @Override
    public BaseEntity selectById(String id) {
        BaseMapper map = (BaseMapper) sqlSession.getMapper(getMapperClass());
        return map.selectById(id);
    }

    @Override
    public List<BaseEntity> selectByIds(List<String> ids) {
        BaseMapper map = (BaseMapper) sqlSession.getMapper(getMapperClass());
        return map.selectByIds(ids);
    }

    @Override
    public BaseEntity deleteById(String id) {
        BaseEntity result = null;
        BaseMapper map = (BaseMapper) sqlSession.getMapper(getMapperClass());
        result = selectById(id);
        map.deleteById(id);
        return result;
    }

    @Override
    public List<BaseEntity> deleteByIds(List<String> ids) {
        List<BaseEntity> result = null;
        BaseMapper map = (BaseMapper) sqlSession.getMapper(getMapperClass());
        result = selectByIds(ids);
        map.deleteByIds(ids);
        return result;
    }

    @Override
    public BaseEntity insertEntity(BaseEntity entity) {
        BaseEntity result = null;
        BaseMapper map = (BaseMapper) sqlSession.getMapper(getMapperClass());
        if ((entity.getId() == null) || (entity.getId().equals(""))) {
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
        }
        map.insertEntity(entity);
        result = selectById(entity.getId());
        return result;
    }

    @Override
    public BaseEntity updateEntity(BaseEntity entity) {
        BaseEntity result = null;
        BaseMapper map = (BaseMapper) sqlSession.getMapper(getMapperClass());
        map.updateEntity(entity);
        result = selectById(entity.getId());
        return result;
    }

    @Override
    public PageInfo<BaseEntity> selectPageByMap(Map<String, Object> params, int pageNum, int pageSize) {
        BaseMapper map = (BaseMapper) sqlSession.getMapper(getMapperClass());
        PageHelper.startPage(pageNum, pageSize);
        List<BaseEntity> list = map.selectPageByMap(params);
        return new PageInfo(list);
    }
}

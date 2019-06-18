package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.RoleFunctionDao;
import com.bugull.locker.entity.RoleFunctionEntity;
import com.bugull.locker.mapper.RoleFunctionMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @program: locker
 * @description: 角色-功能关联
 * @author: Carver Zhang
 * @create: 2019-06-15 14:24
 **/
@Service
public class RoleFunctionDaoImpl implements RoleFunctionDao{

    @Autowired
    protected SqlSession sqlSession;

    @Override
    public Class<?> getEntityClass() {
        return RoleFunctionEntity.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return RoleFunctionMapper.class;
    }

    @Override
    public void insert(RoleFunctionEntity entity) {
        RoleFunctionMapper map = (RoleFunctionMapper) sqlSession.getMapper(getMapperClass());
        if ((entity.getId() == null) || (entity.getId().equals(""))) {
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
        }
        map.insert(entity);
    }

    @Override
    public void delete(String roleId) {
        RoleFunctionMapper map = (RoleFunctionMapper) sqlSession.getMapper(getMapperClass());
        map.delete(roleId);
    }

    @Override
    public int insertBatch(List<RoleFunctionEntity> list) {
        RoleFunctionMapper map = (RoleFunctionMapper) sqlSession.getMapper(getMapperClass());
        return map.insertBatch(list);
    }

    @Override
    public List<RoleFunctionEntity> selectByRoleMenuId(String roleMenuId) {
        RoleFunctionMapper map = (RoleFunctionMapper) sqlSession.getMapper(getMapperClass());
        return map.selectByRoleMenuId(roleMenuId);
    }
}

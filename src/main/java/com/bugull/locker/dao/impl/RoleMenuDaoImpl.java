package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.RoleMenuDao;
import com.bugull.locker.entity.RoleMenuEntity;
import com.bugull.locker.mapper.RoleMenuMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @program: locker
 * @description: 角色-菜单关联
 * @author: Carver Zhang
 * @create: 2019-06-15 14:01
 **/
@Service
public class RoleMenuDaoImpl implements RoleMenuDao {

    @Autowired
    protected SqlSession sqlSession;

    @Override
    public Class<?> getEntityClass() {
        return RoleMenuEntity.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return RoleMenuMapper.class;
    }

    @Override
    public RoleMenuEntity insert(RoleMenuEntity entity) {
        RoleMenuMapper map = (RoleMenuMapper) sqlSession.getMapper(getMapperClass());
        if ((entity.getId() == null) || (entity.getId().equals(""))) {
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
        }
        map.insert(entity);
        return entity;
    }

    @Override
    public void delete(String roleId) {
        RoleMenuMapper map = (RoleMenuMapper) sqlSession.getMapper(getMapperClass());
        map.delete(roleId);
    }

    @Override
    public RoleMenuEntity selectByRole(String roleId) {
        RoleMenuMapper map = (RoleMenuMapper) sqlSession.getMapper(getMapperClass());
        return map.selectByRole(roleId);
    }
}

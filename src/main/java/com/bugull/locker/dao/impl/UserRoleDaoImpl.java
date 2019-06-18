package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.UserRoleDao;
import com.bugull.locker.entity.UserRoleEntity;
import com.bugull.locker.mapper.UserRoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @program: locker
 * @description: 用户-角色关联
 * @author: Carver Zhang
 * @create: 2019-06-14 16:08
 **/
@Service
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    protected SqlSession sqlSession;

    @Override
    public Class<?> getEntityClass() {
        return UserRoleEntity.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return UserRoleMapper.class;
    }

    @Override
    public void insert(UserRoleEntity entity) {
        UserRoleMapper map = (UserRoleMapper) sqlSession.getMapper(getMapperClass());
        if ((entity.getId() == null) || (entity.getId().equals(""))) {
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
        }
        map.insert(entity);
    }

    @Override
    public void delete(String userId) {
        UserRoleMapper map = (UserRoleMapper) sqlSession.getMapper(getMapperClass());
        map.delete(userId);
    }
}

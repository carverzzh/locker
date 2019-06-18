package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.RoleDao;
import com.bugull.locker.entity.RoleEntity;
import com.bugull.locker.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
 * @program: locker
 * @description: 角色管理
 * @author: Carver Zhang
 * @create: 2019-06-14 14:08
 **/
@Service
public class RoleDaoImpl extends BaseDAOImpl implements RoleDao{

    @Override
    public Class<?> getEntityClass() {
        return RoleEntity.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return RoleMapper.class;
    }

    @Override
    public boolean checkRoleExist(String roleName, String roleCode) {
        RoleMapper map = (RoleMapper) sqlSession.getMapper(getEntityClass());
        Integer check = map.checkRoleExist(roleName, roleCode);
        if (check != null && check == 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public RoleEntity deleteByUser(String id, String userId) {
        RoleEntity result = null;
        RoleMapper map = (RoleMapper) sqlSession.getMapper(getEntityClass());
        result = (RoleEntity) map.selectById(id);
        map.deleteByUser(id, userId);
        return result;
    }
}

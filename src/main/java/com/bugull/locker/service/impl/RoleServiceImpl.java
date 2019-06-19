package com.bugull.locker.service.impl;

import com.bugull.locker.dao.BaseDAO;
import com.bugull.locker.dao.RoleDao;
import com.bugull.locker.dao.RoleFunctionDao;
import com.bugull.locker.dao.RoleMenuDao;
import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.RoleEntity;
import com.bugull.locker.entity.RoleFunctionEntity;
import com.bugull.locker.entity.RoleMenuEntity;
import com.bugull.locker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: locker
 * @description: 角色管理
 * @author: Carver Zhang
 * @create: 2019-06-14 14:10
 **/
@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private RoleFunctionDao roleFunctionDao;

    @Override
    protected BaseDAO getBaseDao() {
        return roleDao;
    }

    @Override
    public Class<?> getEntityClass() {
        return RoleEntity.class;
    }

    @Override
    public boolean checkRoleExist(String roleName, String roleCode) {
        return roleDao.checkRoleExist(roleName, roleCode);
    }

    @Override
    public RoleEntity deleteByUser(String id, String userId) {
        roleFunctionDao.delete(id);
        roleMenuDao.delete(id);
        return roleDao.deleteByUser(id, userId);
    }

    @Override
    public BaseEntity insert(RoleEntity entity) {
        BaseEntity result = roleDao.insertEntity(entity);
        List<RoleMenuEntity> roleMenuList = entity.getRoleMenuList();
        handleRoleMenuFunction(roleMenuList, result.getId());
        return roleDao.insertEntity(entity);
    }

    @Override
    public RoleEntity detail(String id) {
        RoleEntity role = (RoleEntity) roleDao.selectById(id);
        List<RoleMenuEntity> roleMenuList = role.getRoleMenuList();
        for (RoleMenuEntity roleMenu : roleMenuList) {
            List<RoleFunctionEntity> list = roleFunctionDao.selectByRoleMenuId(roleMenu.getId());
            roleMenu.setRoleFunctionList(list);
        }
        return role;
    }

    @Override
    public RoleEntity update(RoleEntity entity) {
        roleFunctionDao.delete(entity.getId());
        roleMenuDao.delete(entity.getId());
        List<RoleMenuEntity> roleMenuList = entity.getRoleMenuList();
        handleRoleMenuFunction(roleMenuList, entity.getId());
        return (RoleEntity) roleDao.updateEntity(entity);
    }

    private void handleRoleMenuFunction(List<RoleMenuEntity> roleMenuList, String roleId) {
        for (RoleMenuEntity roleMenu : roleMenuList) {
            roleMenu.setRoleId(roleId);
            roleMenuDao.insert(roleMenu);
            List<RoleFunctionEntity> roleFunctionList = roleMenu.getRoleFunctionList();
            for (RoleFunctionEntity roleFunction : roleFunctionList) {
                roleFunction.setId(UUID.randomUUID().toString().replace("-", ""));
                roleFunction.setRoleMenuId(roleMenu.getId());
            }
            if (roleFunctionList.size() > 0) {
                roleFunctionDao.insertBatch(roleFunctionList);
            }
        }
    }
}

package com.bugull.locker.dao;

import com.bugull.locker.entity.RoleEntity;

public interface RoleDao extends BaseDAO{

    public boolean checkRoleExist(String roleName, String roleCode);

    public RoleEntity deleteByUser(String id, String userId);

}

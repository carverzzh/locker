package com.bugull.locker.service;

import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.RoleEntity;
import com.bugull.locker.service.BaseService;

public interface RoleService extends BaseService {

    public boolean checkRoleExist(String roleName, String roleCode);

    public RoleEntity deleteByUser(String id, String userId);

    public BaseEntity insert(RoleEntity entity);

    public RoleEntity detail(String id);

    public RoleEntity update(RoleEntity entity);
}

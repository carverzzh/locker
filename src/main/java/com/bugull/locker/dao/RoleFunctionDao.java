package com.bugull.locker.dao;

import com.bugull.locker.entity.RoleFunctionEntity;

import java.util.List;

public interface RoleFunctionDao {

    public abstract Class<?> getEntityClass();

    public abstract Class<?> getMapperClass();

    public void insert(RoleFunctionEntity entity);

    public void delete(String roleId);

    public int insertBatch(List<RoleFunctionEntity> list);

    public List<RoleFunctionEntity> selectByRoleMenuId(String roleMenuId);
}

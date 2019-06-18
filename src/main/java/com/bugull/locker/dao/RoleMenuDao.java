package com.bugull.locker.dao;

import com.bugull.locker.entity.RoleMenuEntity;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuDao {

    public abstract Class<?> getEntityClass();

    public abstract Class<?> getMapperClass();

    public RoleMenuEntity insert(RoleMenuEntity entity);

    public void delete(String roleId);

    public RoleMenuEntity selectByRole(String roleId);
}

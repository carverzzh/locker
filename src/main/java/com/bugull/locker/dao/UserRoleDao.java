package com.bugull.locker.dao;

import com.bugull.locker.entity.UserRoleEntity;

public interface UserRoleDao {

    public abstract Class<?> getEntityClass();

    public abstract Class<?> getMapperClass();

    public void insert(UserRoleEntity entity);

    public void delete(String userId);
}

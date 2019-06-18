package com.bugull.locker.mapper;

import com.bugull.locker.entity.RoleMenuEntity;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {

    public void insert(RoleMenuEntity entity);

    public void delete(@Param("roleId") String roleId);

    public RoleMenuEntity selectByRole(@Param("roleId") String roleId);

    public RoleMenuEntity selectById(@Param("id") String id);
}

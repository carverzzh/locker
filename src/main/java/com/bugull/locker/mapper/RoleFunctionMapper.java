package com.bugull.locker.mapper;

import com.bugull.locker.entity.RoleFunctionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleFunctionMapper {

    public void insert(RoleFunctionEntity entity);

    public void delete(@Param("roleId") String roleId);

    public int insertBatch(List<RoleFunctionEntity> list);

    public List<RoleFunctionEntity> selectByRoleMenuId(@Param("roleMenuId") String roleMenuId);
}

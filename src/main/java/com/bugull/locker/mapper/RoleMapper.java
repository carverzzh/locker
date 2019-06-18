package com.bugull.locker.mapper;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends BaseMapper {

    public Integer checkRoleExist(@Param("roleName") String roleName, @Param("roleCode") String roleCode);

    public void deleteByUser(@Param("id") String id, @Param("userId") String userId);
}

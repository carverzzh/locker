package com.bugull.locker.mapper;

import com.bugull.locker.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {

    public void insert(UserRoleEntity entity);

    public void delete(@Param("userId") String userId);
}

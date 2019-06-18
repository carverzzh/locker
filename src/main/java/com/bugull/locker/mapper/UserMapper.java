package com.bugull.locker.mapper;

import com.bugull.locker.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper{

    public Integer checkUsernameExist(@Param("userName") String userName);

    public void deleteByUser(@Param("id") String id, @Param("userId") String userId);

}

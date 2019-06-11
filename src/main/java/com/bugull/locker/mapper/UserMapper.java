package com.bugull.locker.mapper;

import com.bugull.locker.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper{

    /**
     * 普通员工账号列表
     * @param map
     * @return
     */
    List<UserEntity> queryUserList(Map<String, Object> map);


}

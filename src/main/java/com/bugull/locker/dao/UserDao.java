package com.bugull.locker.dao;

import com.bugull.locker.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends BaseDAO {

    public boolean checkUsernameExist(String userName);

    public UserEntity deleteByUser(String id, String userId);
}

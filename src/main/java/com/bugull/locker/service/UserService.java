package com.bugull.locker.service;

import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.UserEntity;

public interface UserService extends BaseService {

    public boolean checkUsernameExist(String userName);

    public BaseEntity insert(UserEntity entity);

    public UserEntity deleteByUser(String id, String userId);

    public UserEntity update(UserEntity entity);
}

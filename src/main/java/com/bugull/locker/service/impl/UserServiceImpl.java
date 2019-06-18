package com.bugull.locker.service.impl;

import com.bugull.locker.dao.BaseDAO;
import com.bugull.locker.dao.UserDao;
import com.bugull.locker.dao.UserRoleDao;
import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.UserEntity;
import com.bugull.locker.entity.UserRoleEntity;
import com.bugull.locker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: locker
 * @description:用户管理
 * @author: Carver Zhang
 * @create: 2019-06-14 16:22
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    protected BaseDAO getBaseDao() {
        return userDao;
    }

    @Override
    public Class<?> getEntityClass() {
        return UserEntity.class;
    }


    @Override
    public boolean checkUsernameExist(String userName) {
        return userDao.checkUsernameExist(userName);
    }

    @Override
    public BaseEntity insert(UserEntity entity) {
        BaseEntity result = userDao.insertEntity(entity);
        UserRoleEntity userRoleEntity = new UserRoleEntity(result.getId(), entity.getRoleId());
        userRoleDao.insert(userRoleEntity);
        return result;
    }

    @Override
    public UserEntity deleteByUser(String id, String userId) {
        return userDao.deleteByUser(id, userId);
    }

    @Override
    public UserEntity update(UserEntity entity) {
        UserEntity result = null;
        result = (UserEntity) userDao.updateEntity(entity);
        if (result.getRoleId() != entity.getRoleId()) {
            userRoleDao.delete(result.getId());
            UserRoleEntity userRoleEntity = new UserRoleEntity(result.getId(), entity.getRoleId());
            userRoleDao.insert(userRoleEntity);
            result.setRoleId(entity.getRoleId());
        }
        return result;
    }
}

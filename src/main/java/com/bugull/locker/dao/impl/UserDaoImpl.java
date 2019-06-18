package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.UserDao;
import com.bugull.locker.entity.UserEntity;
import com.bugull.locker.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @program: locker
 * @description: 用户管理
 * @author: Carver Zhang
 * @create: 2019-06-14 16:20
 **/
@Service
public class UserDaoImpl extends BaseDAOImpl implements UserDao{

    @Override
    public Class<?> getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return UserMapper.class;
    }

    @Override
    public boolean checkUsernameExist(String userName) {
        UserMapper map = (UserMapper) sqlSession.getMapper(getEntityClass());
        Integer check = map.checkUsernameExist(userName);
        if (check != null && check == 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public UserEntity deleteByUser(String id, String userId) {
        UserEntity result = null;
        UserMapper map = (UserMapper) sqlSession.getMapper(getEntityClass());
        result = (UserEntity) map.selectById(id);
        map.deleteByUser(id, userId);
        return result;
    }
}

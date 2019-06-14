package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.MenuDao;
import com.bugull.locker.entity.MenuEntity;
import com.bugull.locker.mapper.MenuMapper;
import com.bugull.locker.vo.MenuFunctionTreeVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: locker
 * @description: 菜单管理
 * @author: Carver Zhang
 * @create: 2019-06-11 17:22
 **/
@Service
public class MenuDaoImpl extends BaseDAOImpl implements MenuDao{

    @Override
    public Class<?> getEntityClass() {
        return MenuEntity.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return MenuMapper.class;
    }

    @Override
    public MenuEntity deleteByUser(String id, String userId) {
        MenuEntity result = null;
        MenuMapper map = (MenuMapper) sqlSession.getMapper(getMapperClass());
        result = (MenuEntity) selectById(id);
        map.deleteByUser(id, userId);
        return result;
    }

    @Override
    public boolean checkMenuExist(String menuName, String menuCode) {
        MenuMapper map = (MenuMapper) sqlSession.getMapper(getMapperClass());
        Integer check = map.checkMenuExist(menuName, menuCode);
        if (check != null && check == 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<MenuFunctionTreeVO> getMenuFunTree() {
        MenuMapper map = (MenuMapper) sqlSession.getMapper(getMapperClass());
        return map.getMenuFunTree();
    }
}

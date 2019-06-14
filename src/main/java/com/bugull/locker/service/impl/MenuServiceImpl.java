package com.bugull.locker.service.impl;

import com.bugull.locker.dao.BaseDAO;
import com.bugull.locker.dao.MenuDao;
import com.bugull.locker.entity.MenuEntity;
import com.bugull.locker.service.MenuService;
import com.bugull.locker.vo.MenuFunctionTreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: locker
 * @description: 菜单管理
 * @author: Carver Zhang
 * @create: 2019-06-11 17:27
 **/
@Service
public class MenuServiceImpl extends BaseServiceImpl implements MenuService{

    @Autowired
    private MenuDao menuDao;

    @Override
    protected BaseDAO getBaseDao() {
        return menuDao;
    }

    @Override
    public Class<?> getEntityClass() {
        return MenuEntity.class;
    }

    @Override
    public MenuEntity deleteByUser(String id, String userId) {
        return menuDao.deleteByUser(id, userId);
    }

    @Override
    public boolean checkMenuExist(String menuName, String menuCode) {
        return menuDao.checkMenuExist(menuName, menuCode);
    }

    @Override
    public List<MenuFunctionTreeVO> getMenuFunTree() {
        return menuDao.getMenuFunTree();
    }
}

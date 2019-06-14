package com.bugull.locker.service;

import com.bugull.locker.entity.MenuEntity;
import com.bugull.locker.vo.MenuFunctionTreeVO;

import java.util.List;

public interface MenuService extends BaseService {

    public MenuEntity deleteByUser(String id, String userId);

    public boolean checkMenuExist(String menuName, String menuCode);

    public List<MenuFunctionTreeVO> getMenuFunTree();
}

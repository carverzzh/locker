package com.bugull.locker.dao;

import com.bugull.locker.entity.MenuEntity;
import com.bugull.locker.vo.MenuFunctionTreeVO;

import java.util.List;

public interface MenuDao extends BaseDAO {

    public MenuEntity deleteByUser(String id, String userId);

    public boolean checkMenuExist(String menuName, String menuCode);

    public List<MenuFunctionTreeVO> getMenuFunTree();

    public MenuFunctionTreeVO getMenuById(String id);
}

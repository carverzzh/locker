package com.bugull.locker.mapper;

import com.bugull.locker.vo.MenuFunctionTreeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends BaseMapper {

    public void deleteByUser(@Param("id") String id, @Param("userId") String userId);

    public Integer checkMenuExist(@Param("menuName") String menuName, @Param("menuCode") String menuCode);

    public List<MenuFunctionTreeVO> getMenuFunTree();

    public MenuFunctionTreeVO getMenuById(@Param("id") String id);
}

package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: locker
 * @description: 角色-菜单关联
 * @author: Carver Zhang
 * @create: 2019-06-15 09:59
 **/
@Getter
@Setter
public class RoleMenuEntity {

    private String id;

    private String roleId;

    private String menuId;

    private List<RoleFunctionEntity> roleFunctionList;

    public RoleMenuEntity() {
    }

    public RoleMenuEntity(String roleId, String menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
        this.roleFunctionList = new ArrayList<>();
    }
}

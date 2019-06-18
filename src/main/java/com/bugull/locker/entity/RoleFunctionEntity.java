package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: locker
 * @description:角色-功能关联
 * @author: Carver Zhang
 * @create: 2019-06-15 10:00
 **/
@Getter
@Setter
public class RoleFunctionEntity {

    private String id;

    private String functionId;

    private String roleMenuId;

    public RoleFunctionEntity() {
    }

    public RoleFunctionEntity(String functionId, String roleMenuId) {
        this.functionId = functionId;
        this.roleMenuId = roleMenuId;
    }
}

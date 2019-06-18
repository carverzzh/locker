package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: locker
 * @description: 用户-角色关联
 * @author: Carver Zhang
 * @create: 2019-06-14 14:15
 **/
@Getter
@Setter
public class UserRoleEntity {

    private String id;

    private String userId;

    private String roleId;

    public UserRoleEntity(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}

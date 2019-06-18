package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: locker
 * @description: 角色
 * @author: Carver Zhang
 * @create: 2019-06-14 13:55
 **/
@Getter
@Setter
public class RoleEntity extends BaseEntity{

    private String roleName;

    private String roleCode;

    private List<RoleMenuEntity> roleMenuList;
}

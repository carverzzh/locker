package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: locker
 * @description: 用户
 * @author: Carver Zhang
 * @create: 2019-06-10 17:00
 **/
@Setter
@Getter
public class UserEntity extends BaseEntity {

    private String username;

    private String password;

    private String userAlias;

    private String phone;

    private String email;

    private String parentId;

    private String roleId;
}

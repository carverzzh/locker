package com.bugull.locker.vo;

import com.bugull.locker.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-14 16:31
 **/
@Getter
@Setter
public class UserVO extends UserEntity{

    private String roleName;

    private String roleCode;


}

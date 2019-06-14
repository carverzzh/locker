package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: locker
 * @description: 菜单
 * @author: Carver Zhang
 * @create: 2019-06-11 16:31
 **/
@Setter
@Getter
public class MenuEntity extends BaseEntity{

    private String menuName;

    private String menuCode;

    private String menuUrl;

    private String parentId;

    private Integer sequence;

    private Integer level;
}

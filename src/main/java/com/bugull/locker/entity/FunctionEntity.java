package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: locker
 * @description: 功能
 * @author: Carver Zhang
 * @create: 2019-06-11 16:27
 **/
@Setter
@Getter
public class FunctionEntity extends BaseEntity {

    private String functionName;

    private String functionCode;

    private String functionUrl;

    private String menuId;

}

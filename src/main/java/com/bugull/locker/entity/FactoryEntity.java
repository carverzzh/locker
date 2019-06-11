package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: locker
 * @description: 工厂
 * @author: Carver Zhang
 * @create: 2019-06-10 17:25
 **/
@Setter
@Getter
public class FactoryEntity extends BaseEntity{

    private String factoryName;

    private String factoryCode;

    private String manager;
}

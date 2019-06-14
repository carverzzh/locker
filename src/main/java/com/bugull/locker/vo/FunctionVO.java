package com.bugull.locker.vo;

import com.bugull.locker.entity.FunctionEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: locker
 * @description: 功能VO
 * @author: Carver Zhang
 * @create: 2019-06-12 13:34
 **/
@Getter
@Setter
public class FunctionVO extends FunctionEntity {

    private String menuName;

    private String menuCode;
}

package com.bugull.locker.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: locker
 * @description: 菜单树结构
 * @author: Carver Zhang
 * @create: 2019-06-14 10:12
 **/
@Setter
@Getter
public class MenuFunctionTreeVO {

    private String menuId;

    private String menuName;

    private String menuUrl;

    private String parentId;

    private Integer sequence;

    private Integer level;

    private List<FunctionTreeVO> funTrees;
}

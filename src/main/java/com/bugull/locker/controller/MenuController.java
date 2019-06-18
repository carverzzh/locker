package com.bugull.locker.controller;

import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.FactoryEntity;
import com.bugull.locker.entity.MenuEntity;
import com.bugull.locker.response.ApiResult;
import com.bugull.locker.service.MenuService;
import com.bugull.locker.vo.MenuFunctionTreeVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: locker
 * @description: 菜单管理
 * @author: Carver Zhang
 * @create: 2019-06-11 17:30
 **/
@Api(description = "Menu")
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "selectPageByMap", notes = "菜单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuName", value = "菜单名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "menuCode", value = "菜单编码", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "pageNumber", required = false, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = false, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/selectPageByMap", method = RequestMethod.GET)
    public ApiResult<PageInfo<BaseEntity>> selectPageByMap(@RequestParam(required = false) String menuName,
                                                           @RequestParam(required = false) String menuCode,
                                                           @RequestParam(required = false, defaultValue="1") int pageNumber,
                                                           @RequestParam(required = false, defaultValue="10") int pageSize) {
        Map<String, Object> queryParam = new HashMap<>(2);
        queryParam.put("menuName", menuName);
        queryParam.put("menuCode", menuCode);
        return ApiResult.success(menuService.selectPageByMap(queryParam, pageNumber, pageSize));
    }

    @ApiOperation(value = "insert", notes = "添加菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, paramType = "insert", dataType = "Object")
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ApiResult<BaseEntity> insert(@RequestBody MenuEntity menu) {
        menu.setModifyUser(menu.getCreateUser());
        return ApiResult.success(menuService.insertEntity(menu));
    }

    @ApiOperation(value = "delete", notes = "删除菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单id", required = true, paramType = "delete", dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "操作人员id", required = true, paramType = "delete", dataType = "String")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ApiResult<MenuEntity> delete(@RequestParam(required = true) String id, @RequestParam(required = true) String userId) {
        return ApiResult.success(menuService.deleteByUser(id, userId));
    }

    @ApiOperation(value = "update", notes = "更新菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, paramType = "update", dataType = "Object")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult<BaseEntity> update(@RequestBody MenuEntity menu) {
        return ApiResult.success(menuService.updateEntity(menu));
    }

    @ApiOperation(value = "checkMenu", notes = "菜单查重")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuName", value = "菜单名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "menuCode", value = "菜单编码", required = false, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/checkFactory", method = RequestMethod.POST)
    public ApiResult<Boolean> checkFactory(@RequestParam(required = false) String menuName, @RequestParam(required = false) String menuCode) {
        return ApiResult.success(menuService.checkMenuExist(menuName, menuCode));
    }

    @ApiOperation(value = "getMenuFunTree", notes = "获取菜单功能树")
    @RequestMapping(value = "/getMenuFunTree", method = RequestMethod.GET)
    public ApiResult<List<MenuFunctionTreeVO>> getMenuFunTree() {
        return ApiResult.success(menuService.getMenuFunTree());
    }

    @ApiOperation(value = "getMenuById", notes = "获取菜单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单id", required = false, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/getMenuById", method = RequestMethod.GET)
    public ApiResult<MenuFunctionTreeVO> getMenuById(@RequestParam(required = false) String id) {
        return ApiResult.success(menuService.getMenuById(id));
    }
}

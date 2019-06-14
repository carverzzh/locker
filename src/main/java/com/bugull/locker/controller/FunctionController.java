package com.bugull.locker.controller;

import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.FunctionEntity;
import com.bugull.locker.entity.MenuEntity;
import com.bugull.locker.response.ApiResult;
import com.bugull.locker.service.FunctionService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: locker
 * @description: 功能管理
 * @author: Carver Zhang
 * @create: 2019-06-13 15:24
 **/
@Api(description = "Function")
@Slf4j
@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @ApiOperation(value = "selectPageByMap", notes = "功能列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "functionName", value = "功能名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "functionCode", value = "功能编码", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "menuName", value = "菜单名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "pageNumber", required = false, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = false, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/selectPageByMap", method = RequestMethod.GET)
    public ApiResult<PageInfo<BaseEntity>> selectPageByMap(@RequestParam(required = false) String functionName,
                                                           @RequestParam(required = false) String functionCode,
                                                           @RequestParam(required = false) String menuName,
                                                           @RequestParam(required = false, defaultValue="1") int pageNumber,
                                                           @RequestParam(required = false, defaultValue="10") int pageSize) {
        Map<String, Object> queryParam = new HashMap<>(3);
        queryParam.put("menuName", menuName);
        queryParam.put("functionName", functionName);
        queryParam.put("functionCode", functionCode);
        return ApiResult.success(functionService.selectPageByMap(queryParam, pageNumber, pageSize));

    }

    @ApiOperation(value = "insert", notes = "添加功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "function", value = "功能对象", required = true, paramType = "insert", dataType = "Object")
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ApiResult<BaseEntity> insert(@RequestBody FunctionEntity function) {
        function.setModifyUser(function.getCreateUser());
        return ApiResult.success(functionService.insertEntity(function));
    }

    @ApiOperation(value = "delete", notes = "删除功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "功能id", required = true, paramType = "delete", dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "操作人员id", required = true, paramType = "delete", dataType = "String")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ApiResult<FunctionEntity> delete(@RequestParam(required = true) String id, @RequestParam(required = true) String userId) {
        return ApiResult.success(functionService.deleteByUser(id, userId));
    }

    @ApiOperation(value = "update", notes = "更新功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "function", value = "功能对象", required = true, paramType = "update", dataType = "Object")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult<BaseEntity> update(@RequestBody FunctionEntity function) {
        return ApiResult.success(functionService.updateEntity(function));
    }

    @ApiOperation(value = "checkMenu", notes = "功能查重")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "functionName", value = "功能名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "functionCode", value = "功能编码", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "menuId", value = "菜单id", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/checkFactory", method = RequestMethod.POST)
    public ApiResult<Boolean> checkFactory(@RequestParam(required = false) String functionName, @RequestParam(required = false) String functionCode,
                                           @RequestParam(required = true) String menuId) {
        return ApiResult.success(functionService.checkFunctionExist(functionName, functionCode, menuId));
    }


}

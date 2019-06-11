package com.bugull.locker.controller;

import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.FactoryEntity;
import com.bugull.locker.response.ApiResult;
import com.bugull.locker.service.FactoryService;
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
 * @description: 工厂管理
 * @author: Carver Zhang
 * @create: 2019-06-11 14:01
 **/
@Api(description = "Factory")
@Slf4j
@RestController
@RequestMapping("/factory")
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    @ApiOperation(value = "selectPageByMap", notes = "工厂列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "factoryName", value = "工厂名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "factoryCode", value = "工厂编码", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "pageNumber", required = false, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = false, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/selectPageByMap", method = RequestMethod.GET)
    public ApiResult<PageInfo<BaseEntity>> selectPageByMap(@RequestParam(required = false) String factoryName,
                                                           @RequestParam(required = false) String factoryCode,
                                                           @RequestParam(required = false, defaultValue="1") int pageNumber,
                                                           @RequestParam(required = false, defaultValue="10") int pageSize) {
        Map<String, Object> queryParam = new HashMap<>(2);
        queryParam.put("factoryName", factoryName);
        queryParam.put("factoryCode", factoryCode);
        return ApiResult.success(factoryService.selectPageByMap(queryParam, pageNumber, pageSize));
    }

    @ApiOperation(value = "insert", notes = "添加工厂")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "factory", value = "工厂对象", required = true, paramType = "insert", dataType = "Object")
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ApiResult<BaseEntity> insert(@RequestBody FactoryEntity factory) {
        factory.setModifyUser(factory.getCreateUser());
        return ApiResult.success(factoryService.insertEntity(factory));
    }

    @ApiOperation(value = "delete", notes = "删除工厂")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "工厂id", required = true, paramType = "delete", dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "操作人员id", required = true, paramType = "delete", dataType = "String")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ApiResult<FactoryEntity> delete(@RequestParam(required = true) String id, @RequestParam(required = true) String userId) {
        return ApiResult.success(factoryService.deleteByUser(id, userId));
    }

    @ApiOperation(value = "update", notes = "更新工厂")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "factory", value = "工厂对象", required = true, paramType = "update", dataType = "Object")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult<BaseEntity> update(@RequestBody FactoryEntity factory) {
        return ApiResult.success(factoryService.updateEntity(factory));
    }

    @ApiOperation(value = "checkFactory", notes = "工厂查重")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "factoryName", value = "工厂名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "factoryCode", value = "工厂编码", required = false, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/checkFactory", method = RequestMethod.POST)
    public ApiResult<Boolean> checkFactory(@RequestParam(required = false) String factoryName, @RequestParam(required = false) String factoryCode) {
        return ApiResult.success(factoryService.checkFacExist(factoryName, factoryCode));
    }


}

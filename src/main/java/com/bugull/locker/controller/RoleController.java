package com.bugull.locker.controller;

import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.RoleEntity;
import com.bugull.locker.response.ApiResult;
import com.bugull.locker.service.RoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: locker
 * @description: 角色管理
 * @author: Carver Zhang
 * @create: 2019-06-17 09:10
 **/
@Api(description = "Role")
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "selectPageByMap", notes = "角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "roleCode", value = "角色代码", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "pageNumber", required = false, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = false, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/selectPageByMap", method = RequestMethod.GET)
    public ApiResult<PageInfo<BaseEntity>> selectPageByMap(@RequestParam(required = false) String roleName,
                                                           @RequestParam(required = false) String roleCode,
                                                           @RequestParam(required = false, defaultValue="1") int pageNumber,
                                                           @RequestParam(required = false, defaultValue="10") int pageSize) {
        Map<String, Object> queryParam = new HashMap<>(2);
        queryParam.put("roleName", roleName);
        queryParam.put("roleCode", roleCode);
        return ApiResult.success(roleService.selectPageByMap(queryParam, pageNumber, pageSize));
    }

    @ApiOperation(value = "checkRole", notes = "角色查重")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "roleCode", value = "角色代码", required = false, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/checkRole", method = RequestMethod.POST)
    public ApiResult<Boolean> checkRole(@RequestParam(required = false) String roleName, @RequestParam(required = false) String roleCode) {
        return ApiResult.success(roleService.checkRoleExist(roleName, roleCode));
    }

    @ApiOperation(value = "delete", notes = "删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, paramType = "delete", dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "操作人员id", required = true, paramType = "delete", dataType = "String")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ApiResult<RoleEntity> delete(@RequestParam(required = true) String id, @RequestParam(required = true) String userId) {
        return ApiResult.success(roleService.deleteByUser(id, userId));
    }

    @ApiOperation(value = "insert", notes = "添加角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "角色对象", required = true, paramType = "insert", dataType = "Object")
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ApiResult<BaseEntity> insert(@RequestBody RoleEntity role) {
        role.setModifyUser(role.getCreateUser());
        return ApiResult.success(roleService.insert(role));
    }

    @ApiOperation(value = "detail", notes = "角色详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ApiResult<RoleEntity> detail(@RequestParam(required = true) String id) {
        return ApiResult.success(roleService.detail(id));
    }
}

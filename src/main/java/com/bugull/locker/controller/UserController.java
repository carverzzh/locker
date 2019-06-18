package com.bugull.locker.controller;

import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.FunctionEntity;
import com.bugull.locker.entity.UserEntity;
import com.bugull.locker.response.ApiResult;
import com.bugull.locker.service.UserService;
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
 * @description: 用户管理
 * @author: Carver Zhang
 * @create: 2019-06-14 16:23
 **/
@Api(description = "User")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "selectPageByMap", notes = "用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAlias", value = "用户昵称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "联系电话", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "email", value = "邮箱地址", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "pageNumber", required = false, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = false, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/selectPageByMap", method = RequestMethod.GET)
    public ApiResult<PageInfo<BaseEntity>> selectPageByMap(@RequestParam(required = false) String userAlias,
                                                           @RequestParam(required = false) String phone,
                                                           @RequestParam(required = false) String email,
                                                           @RequestParam(required = false) String roleName,
                                                           @RequestParam(required = false, defaultValue="1") int pageNumber,
                                                           @RequestParam(required = false, defaultValue="10") int pageSize) {
        Map<String, Object> queryParam = new HashMap<>(4);
        queryParam.put("userAlias", userAlias);
        queryParam.put("phone", phone);
        queryParam.put("email", email);
        queryParam.put("roleName", roleName);
        return ApiResult.success(userService.selectPageByMap(queryParam, pageNumber, pageSize));
    }

    @ApiOperation(value = "checkUsername", notes = "用户名查重")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = false, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public ApiResult<Boolean> checkUsername(@RequestParam(required = false) String userName) {
        return ApiResult.success(userService.checkUsernameExist(userName));
    }

    @ApiOperation(value = "insert", notes = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, paramType = "insert", dataType = "Object")
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ApiResult<BaseEntity> insert(@RequestBody UserEntity user) {
        return ApiResult.success(userService.insert(user));
    }

    @ApiOperation(value = "delete", notes = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "delete", dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "操作人员id", required = true, paramType = "delete", dataType = "String")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ApiResult<UserEntity> delete(@RequestParam(required = true) String id, @RequestParam(required = true) String userId) {
        return ApiResult.success(userService.deleteByUser(id, userId));
    }

    @ApiOperation(value = "update", notes = "更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, paramType = "update", dataType = "Object")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult<UserEntity> update(@RequestBody UserEntity user) {
        return ApiResult.success(userService.update(user));
    }
}

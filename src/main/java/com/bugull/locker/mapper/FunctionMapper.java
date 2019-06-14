package com.bugull.locker.mapper;

import org.apache.ibatis.annotations.Param;

public interface FunctionMapper extends BaseMapper {

    public void deleteByUser(@Param("id") String id, @Param("userId") String userId);

    public Integer checkFunctionExist(@Param("functionName") String functionName, @Param("functionCode") String functionCode,
                                      @Param("menuId") String menuId);
}

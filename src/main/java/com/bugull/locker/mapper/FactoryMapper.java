package com.bugull.locker.mapper;

import com.bugull.locker.entity.FactoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FactoryMapper extends BaseMapper {

    public void deleteByUser(@Param("id") String id, @Param("userId") String userId);

    public Integer checkFacExist(@Param("factoryName") String factoryName, @Param("factoryCode") String factoryCode);
}

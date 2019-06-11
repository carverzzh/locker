package com.bugull.locker.mapper;

import com.bugull.locker.entity.FactoryEntity;

import java.util.List;
import java.util.Map;

public interface FactoryMapper extends BaseMapper {

    List<FactoryEntity> queryFactoryList(Map<String, Object> map);
}

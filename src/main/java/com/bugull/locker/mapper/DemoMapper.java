package com.bugull.locker.mapper;

import com.bugull.locker.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-05 15:49
 **/
@Repository
@Mapper
public interface DemoMapper extends BaseMapper{

    List<Demo> queryDemo();
}

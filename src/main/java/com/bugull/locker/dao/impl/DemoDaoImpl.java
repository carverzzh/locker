package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.DemoDao;
import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.Demo;
import com.bugull.locker.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-05 14:45
 **/
@Service
public class DemoDaoImpl implements DemoDao {

    @Resource
    private DemoMapper demoMapper;

    @Override
    public String strDemo() {
        return "Hello World";
    }

    @Override
    public List<Demo> queryDemo() {
        return demoMapper.queryDemo();
    }

    @Override
    public BaseEntity selectById(String id) {
        return null;
    }

    @Override
    public List<BaseEntity> selectByIds(List<String> ids) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteByIds(List<String> ids) {

    }

    @Override
    public void insertEntity(BaseEntity entity) {

    }

    @Override
    public void updateEntity(BaseEntity entity) {

    }

    @Override
    public List<BaseEntity> selectPageByMap(Map<String, Object> map, int pageNum, int pageSize) {
        return null;
    }
}

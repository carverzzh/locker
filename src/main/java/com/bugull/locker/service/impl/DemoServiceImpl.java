package com.bugull.locker.service.impl;

import com.bugull.locker.dao.DemoDao;
import com.bugull.locker.entity.BaseEntity;
import com.bugull.locker.entity.Demo;
import com.bugull.locker.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-05 13:31
 **/
@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoDao demoDao;

    @Override
    public String strDemo() {
        return demoDao.strDemo();
    }

    @Override
    public List<Demo> queryDemo() {
        return demoDao.queryDemo();
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

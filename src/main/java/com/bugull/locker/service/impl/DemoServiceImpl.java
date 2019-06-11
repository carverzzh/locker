package com.bugull.locker.service.impl;

import com.bugull.locker.dao.BaseDAO;
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
public class DemoServiceImpl extends BaseServiceImpl implements DemoService{

    @Autowired
    private DemoDao demoDao;

    @Override
    public Class<?> getEntityClass() {
        return Demo.class;
    }

    @Override
    protected BaseDAO getBaseDao() {
        return demoDao;
    }

    @Override
    public String strDemo() {
        return demoDao.strDemo();
    }

    @Override
    public List<Demo> queryDemo() {
        return demoDao.queryDemo();
    }
}

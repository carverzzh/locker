package com.bugull.locker.service.impl;

import com.bugull.locker.dao.DemoDao;
import com.bugull.locker.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

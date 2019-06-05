package com.bugull.locker.dao.impl;

import com.bugull.locker.dao.DemoDao;
import org.springframework.stereotype.Service;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-05 14:45
 **/
@Service
public class DemoDaoImpl implements DemoDao {


    @Override
    public String strDemo() {
        return "Hello World";
    }
}

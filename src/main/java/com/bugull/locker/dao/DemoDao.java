package com.bugull.locker.dao;

import com.bugull.locker.entity.Demo;

import java.util.List;

public interface DemoDao extends BaseDAO{

    public String strDemo();

    public List<Demo> queryDemo();
}

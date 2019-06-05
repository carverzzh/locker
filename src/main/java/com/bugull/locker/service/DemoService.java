package com.bugull.locker.service;

import com.bugull.locker.entity.Demo;

import java.util.List;

public interface DemoService extends BaseService{

    public String strDemo();

    public List<Demo> queryDemo();
}

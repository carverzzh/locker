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
public class DemoDaoImpl extends BaseDAOImpl implements DemoDao {

    @Override
    public Class<?> getEntityClass() {
        return Demo.class;
    }

    @Override
    public Class<?> getMapperClass() {
        return DemoMapper.class;
    }

    @Override
    public String strDemo() {
        return "Hello World";
    }

    @Override
    public List<Demo> queryDemo() {
        DemoMapper mapper = (DemoMapper) sqlSession.getMapper(this.getMapperClass());
        return mapper.queryDemo();
    }
}

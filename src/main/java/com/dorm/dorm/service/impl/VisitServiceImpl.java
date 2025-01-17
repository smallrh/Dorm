package com.dorm.dorm.service.impl;

import com.dorm.dorm.mapper.VisitMapper;
import com.dorm.dorm.request.VisitRequest;
import com.dorm.dorm.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitMapper visitMapper;

    @Override
    public boolean addVisitor(VisitRequest visitRequest) {
        // 调用Mapper层方法，插入数据库
        return visitMapper.insertVisitor(visitRequest) > 0;
    }
}

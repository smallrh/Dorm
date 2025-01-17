package com.dorm.dorm.service.impl;

import com.dorm.dorm.entity.Consume;
import com.dorm.dorm.mapper.ConsumeMapper;
import com.dorm.dorm.request.ConsumeRequest;
import com.dorm.dorm.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumeServiceImpl implements ConsumeService {
    @Autowired
    private ConsumeMapper consumeMapper;

    @Override
    public Consume consume(ConsumeRequest request) {
        return consumeMapper.consume(request);
    }
}

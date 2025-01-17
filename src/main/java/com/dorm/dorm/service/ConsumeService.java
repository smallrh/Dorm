package com.dorm.dorm.service;

import com.dorm.dorm.entity.Consume;
import com.dorm.dorm.request.ConsumeRequest;

public interface ConsumeService {
    Consume consume(ConsumeRequest request);
}

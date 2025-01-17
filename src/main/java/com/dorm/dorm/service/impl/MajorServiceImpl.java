package com.dorm.dorm.service.impl;

import com.dorm.dorm.entity.Major;
import com.dorm.dorm.mapper.MajorMapper;
import com.dorm.dorm.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public List<Major> getAllMajors() {
        return majorMapper.getAllMajors();
    }

    @Override
    public List<Major> getMajorsByDept(String dNo) {
        return majorMapper.getMajorByDept(dNo);
    }
}

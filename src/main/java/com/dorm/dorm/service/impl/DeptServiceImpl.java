package com.dorm.dorm.service.impl;

import com.dorm.dorm.entity.Dept;
import com.dorm.dorm.mapper.DeptMapper;
import com.dorm.dorm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getAllDepts() {
        return deptMapper.selectAllDepts();
    }
}


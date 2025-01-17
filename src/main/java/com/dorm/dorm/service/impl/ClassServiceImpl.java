package com.dorm.dorm.service.impl;

import com.dorm.dorm.entity.Class;
import com.dorm.dorm.mapper.ClassMapper;
import com.dorm.dorm.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<Class> getClassesByMajor(String mNo) {
        return classMapper.getClassesByMajor(mNo);
    }
}

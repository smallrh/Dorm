package com.dorm.dorm.service;

import com.dorm.dorm.entity.Class;

import java.util.List;

public interface ClassService {
    public List<Class> getClassesByMajor(String mNo);
}

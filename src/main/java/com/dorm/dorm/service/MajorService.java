package com.dorm.dorm.service;

import com.dorm.dorm.entity.Major;

import java.util.List;

public interface MajorService {
    List<Major> getAllMajors();

    List<Major> getMajorsByDept(String dNo); // 根据系别编号查询专业
}


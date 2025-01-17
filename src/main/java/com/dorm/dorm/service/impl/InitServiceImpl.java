package com.dorm.dorm.service.impl;

import com.dorm.dorm.mapper.AdminMapper;
import com.dorm.dorm.mapper.HouseparentMapper;
import com.dorm.dorm.mapper.StudentMapper;
import com.dorm.dorm.entity.Admin;
import com.dorm.dorm.entity.Houseparent;
import com.dorm.dorm.entity.Student;
import com.dorm.dorm.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private HouseparentMapper houseparentMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String getInitData(String sNo) {
        try {
            // 查询 student 表
            Student student = studentMapper.findBySNo(sNo);
            if (student != null) {
                return readJsonFile("static/api/initForsd.json");
            }

            // 查询 houseparent 表
            Houseparent houseparent = houseparentMapper.findByHNo(sNo);
            if (houseparent != null) {
                return readJsonFile("static/api/initForAc.json");
            }

            // 查询 admin 表
            Admin admin = adminMapper.findByANo(sNo);
            if (admin != null) {
                return readJsonFile("static/api/initForAd.json");
            }

            return "No matching record found";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to read JSON file";
        }
    }

    private String readJsonFile(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        Path path = resource.getFile().toPath();
        System.out.println(filePath + " path: " + path);
        return Files.readString(path);
    }
}

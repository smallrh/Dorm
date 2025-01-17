package com.dorm.dorm.service.impl;

import com.dorm.dorm.entity.Student;
import com.dorm.dorm.mapper.AdminMapper;
import com.dorm.dorm.mapper.UserMapper;
import com.dorm.dorm.request.RegisterRequest;
import com.dorm.dorm.service.AdminService;
import com.dorm.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Student getStudentByCredentials(String username, String password) {
        return userMapper.getStudentByCredentials(username, password);
    }

    @Override
    public boolean registerUser(RegisterRequest request) {
        // 检查学号是否已存在
        if (userMapper.existsByUsername(request.getUsername())) {
            return false;  // 学号已存在
        }

        // 创建新用户并保存
        Student newUser = new Student();
        System.out.println(request.toString());
        newUser.setSName(request.getName());
        newUser.setSNo(request.getUsername());
        newUser.setSPwd(request.getPassword());
        newUser.setSId(request.getS_id());
        newUser.setSSex(request.getS_sex());
        newUser.setSFrom("无");
        newUser.setSGrade(request.getS_grade());
        newUser.setSRs("无");
        newUser.setCNo(request.getC_no());
        userMapper.save(newUser);
        return true;
    }

    @Override
    public void updatePassword(String newPassword, String sNo) {
        userMapper.updatePassword(newPassword, sNo);
    }
}

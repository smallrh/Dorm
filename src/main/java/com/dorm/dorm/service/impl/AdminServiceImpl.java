package com.dorm.dorm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dorm.dorm.mapper.AdminMapper;
import com.dorm.dorm.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean validateAdmin(String username, String password) {
        return adminMapper.countAdminByCredentials(username, password) > 0;
    }
}

package com.dorm.dorm.service;

import com.dorm.dorm.entity.Student;
import com.dorm.dorm.request.RegisterRequest;

public interface UserService {
    Student getStudentByCredentials(String username, String password);

    boolean registerUser(RegisterRequest request);

    void updatePassword(String newPassword, String sNo);
}

package com.dorm.dorm.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String username;
    private String password;
    private String s_sex;
    private String s_id;
    private String c_no;
    private String s_grade;
}

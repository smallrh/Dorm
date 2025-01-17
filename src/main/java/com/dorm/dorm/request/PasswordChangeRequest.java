package com.dorm.dorm.request;

import lombok.Data;

@Data
public class PasswordChangeRequest {
    private String old_password;
    private String new_password;
    private String again_password;
    private String s_no;
}


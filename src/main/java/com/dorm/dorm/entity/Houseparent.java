package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Houseparent {
    private String hNo;       // 宿管员编号
    private String hName;     // 宿管员姓名
    private String hSex;      // 宿管员性别
    private String hPwd;      // 宿管员密码
    private String hId;       // 身份证号
    private Date hStartwork;  // 入职时间
}

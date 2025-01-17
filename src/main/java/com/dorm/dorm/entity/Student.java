package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String sNo;       // 学号
    private String sName;     // 姓名
    private String sFrom;     // 籍贯
    private String sId;       // 身份证号
    private String sPwd;      // 密码
    private String sSex;      // 性别
    private String sGrade;    // 年级
    private String sRs;       // 住宿状态
    private String cNo;       // 班级编号
}

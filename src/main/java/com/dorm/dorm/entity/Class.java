package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    private String cNo;       // 班级编号
    private String cName;     // 班级名称
    private String mNo;       // 专业编号
}
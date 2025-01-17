package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {
    private String dNo;       // 违纪编号
    private String sNo;       // 学号
    private Date dTime;       // 违纪时间
    private String dReason;   // 违纪原因
    private String dPanish;   // 处罚
    private String dPanishType; // 处罚类型
}

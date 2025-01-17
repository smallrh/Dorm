package com.dorm.dorm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {
    private String dTime;      // 违纪时间
    private String dReason;  // 违纪原因
    private String dPanish;  // 处罚
    private String dPanishType; // 处罚类型
    private String sName;
    private String major;

}

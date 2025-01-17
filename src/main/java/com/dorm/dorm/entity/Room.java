package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String rNo;       // 房间号
    private String bDno;      // 楼号
    private Double rMoney;    // 住宿费
    private Integer rSum;     // 房间总人数
    private Integer rSumfact; // 房间实住人数
    private Double cOldcwater; // 冷水表初始读数
    private Double cOldhwater; // 热水表初始读数
    private Double cOldelec;  // 电表初始读数
    private String rNote;     // 备注
}
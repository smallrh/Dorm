package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consume {
    private String rNo;       // 房间号
    private Integer cYear;    // 年份
    private Integer cMonth;   // 月份
    private Double cSumwe;    // 总水电费
    private Double cCwater;   // 冷水表读数
    private Double cCcw;      // 冷水单价
    private Double cCsum;     // 冷水费
    private Double cHwater;   // 热水表读数
    private Double cHcw;      // 热水单价
    private Double cHsum;     // 热水费
    private Double cElec;     // 电表读数
    private Double cEc;       // 电费
}

package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rs {
    private String sNo;       // 学号
    private String rNo;       // 房间号
    private Integer rsBed;    // 床位号
    private Date rsEnter;     // 入住时间
    private Date rsLeave;     // 迁出时间
}

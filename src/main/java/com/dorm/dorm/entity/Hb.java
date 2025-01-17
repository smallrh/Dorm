package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hb {
    private String bDno;      // 楼号
    private String hNo;       // 宿管员编号
    private Date hbTime;      // 分配时间
}

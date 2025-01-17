package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    private String bDno;      // 楼号
    private Integer bFloor;   // 楼层数
    private Integer bRoom;    // 每层楼的房间数量
    private String bSex;      // 性别
    private Integer bTotal;   // 总床位数
    private String bLift;     // 电梯
    private Integer bNow;     // 当前入住人数
}

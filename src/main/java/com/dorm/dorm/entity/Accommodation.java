package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {
    private String sNo;       // 学号
    private String rNo;       // 房间号
    private Date acDate;      // 申请日期
    private String acReason;  // 申请原因
    private String acState;   // 申请状态
    private String acNote;    // 备注
    private String acTel;     // 联系电话
}

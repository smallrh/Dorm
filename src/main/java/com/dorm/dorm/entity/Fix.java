package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fix {
    private String fRno;      // 房间号
    private String fSno;      // 学号
    private Date fStart;      // 申请时间
    private String fReason;   // 维修原因
    private String fTel;      // 联系电话
    private String fNote;     // 备注
    private Date fEnd;        // 完成时间
}

package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit {
    private String vName;     // 来访者姓名
    private String vId;       // 来访者身份证
    private String sNo;       // 被访学生学号
    private Date vStart;      // 来访开始时间
    private String vReason;   // 来访原因
    private Date vEnd;        // 来访结束时间
    private String vPhone;    // 联系电话
}

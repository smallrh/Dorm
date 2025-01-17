package com.dorm.dorm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixDTO {
    private String fStart;      // 申请时间
    private String fReason;   // 维修原因
    private String fRno;      // 房间号
    private String bNo;       // 楼号

    // 方法用于格式化 fStart 字段为 yyyy-MM-dd 格式
    public String setFormattedFStart(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public FixDTO(Date fStart, String fReason, String fRno, String bNo) {
        this.fStart = setFormattedFStart(fStart);
        this.fReason = fReason;
        this.fRno = fRno;
        this.bNo = bNo;
    }
}

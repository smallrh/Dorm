package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Major {
    private String mNo;       // 专业编号
    private String mName;     // 专业名称
    private Integer mYear;    // 学制
    private String dNo;       // 系别编号
}

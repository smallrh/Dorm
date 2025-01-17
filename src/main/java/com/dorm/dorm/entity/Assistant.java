package com.dorm.dorm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assistant {
    private String aNum;      // 宿管员工号
    private String aPwd;      // 宿管员密码
    private String adNo;      // 部门编号
}

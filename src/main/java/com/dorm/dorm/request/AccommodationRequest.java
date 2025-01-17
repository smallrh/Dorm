package com.dorm.dorm.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccommodationRequest {

    @JsonProperty("s_no")    // 映射 JSON 中的 "s_no" 到 Java 中的 sNo
    private String sNo;       // 学号

    @JsonProperty("r_no")    // 映射 JSON 中的 "r_no" 到 Java 中的 rNo
    private String rNo;       // 房间号

    @JsonProperty("ac_date") // 映射 JSON 中的 "ac_date" 到 Java 中的 acDate
    private String acDate;    // 申请日期

    @JsonProperty("ac_reason") // 映射 JSON 中的 "ac_reason" 到 Java 中的 acReason
    private String acReason;  // 申请原因

    @JsonProperty("ac_state")  // 映射 JSON 中的 "ac_state" 到 Java 中的 acState
    private String acState;   // 申请状态

    @JsonProperty("ac_note")   // 映射 JSON 中的 "ac_note" 到 Java 中的 acNote
    private String acNote;    // 备注

    @JsonProperty("ac_tel")   // 映射 JSON 中的 "ac_tel" 到 Java 中的 acTel
    private String acTel;     // 联系电话
}


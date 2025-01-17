package com.dorm.dorm.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VisitRequest {
    @JsonProperty("visitorName")  // 前端字段名称
    private String v_name;  // 后端字段名称

    @JsonProperty("visitorId")
    private String v_id;

    @JsonProperty("s_no")
    private String s_no;

    @JsonProperty("visitStart")
    private String v_start;

    @JsonProperty("visitReason")
    private String v_reason;

    @JsonProperty("visitEnd")
    private String v_end;

    @JsonProperty("visitorPhone")
    private String v_phone;
}



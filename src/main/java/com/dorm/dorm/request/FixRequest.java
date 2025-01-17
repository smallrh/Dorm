package com.dorm.dorm.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixRequest {
    @JsonProperty("fReason")
    private String fReason;   // 维修原因
    @JsonProperty("fTel")
    private String fTel;      // 联系电话
    @JsonProperty("fNote")
    private String fNote;     // 备注
    @JsonProperty("fRno")
    private String fRno;      // 房间号
    @JsonProperty("fSno")
    private String fSno;      // 学号
}

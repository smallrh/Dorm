package com.dorm.dorm.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConsumeRequest {
    @JsonProperty("month")
    private String month;
    @JsonProperty("rNo")
    private String rNo;
    private String year;
}

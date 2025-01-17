package com.dorm.dorm.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DisciplineRequest {

    private int page;
    private int limit;
    @JsonProperty("sNo")
    private String sNo;
}

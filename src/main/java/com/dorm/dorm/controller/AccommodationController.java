package com.dorm.dorm.controller;

import com.dorm.dorm.request.AccommodationRequest;
import com.dorm.dorm.respose.ApiResponse;
import com.dorm.dorm.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccommodationController {

    @Autowired
    private AccommodationService accommodationService;

    // 住宿申请接口
    @PostMapping("/accommodation")
    public ApiResponse requestAccommodation(@RequestBody AccommodationRequest accommodationRequest) {
        // 调用 service 层处理住宿申请
        boolean success = accommodationService.requestAccommodation(accommodationRequest);

        if (success) {
            return ApiResponse.success("住宿申请提交成功");
        } else {
            return ApiResponse.error("住宿申请提交失败，检查房间或学号是否有效");
        }
    }
}


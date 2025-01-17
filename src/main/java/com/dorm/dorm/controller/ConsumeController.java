package com.dorm.dorm.controller;

import com.dorm.dorm.entity.Consume;
import com.dorm.dorm.request.ConsumeRequest;
import com.dorm.dorm.respose.ApiResponse;
import com.dorm.dorm.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;

    @PostMapping("/consume")
    public ApiResponse consume(@RequestBody ConsumeRequest request) {
        Consume consume = consumeService.consume(request);
        if (consume != null) {
            return ApiResponse.success("成功", consume);
        }
        return ApiResponse.error("未找到当月费用");
    }
}

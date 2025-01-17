package com.dorm.dorm.controller;

import com.dorm.dorm.request.VisitRequest;
import com.dorm.dorm.respose.ResultResponse;
import com.dorm.dorm.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @PostMapping("visitor/add")
    public ResultResponse<?> addVisitor(@RequestBody VisitRequest visitRequest) {
        // 调用Service层的逻辑
        boolean result = visitService.addVisitor(visitRequest);
        if (result) {
            return ResultResponse.success("来访登记成功");
        } else {
            return ResultResponse.error("来访登记失败");
        }
    }
}

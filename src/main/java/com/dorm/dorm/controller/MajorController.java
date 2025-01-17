package com.dorm.dorm.controller;

import com.dorm.dorm.entity.Major;
import com.dorm.dorm.respose.ApiResponse;
import com.dorm.dorm.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MajorController {

    @Autowired
    private MajorService majorService;

    // 获取所有专业列表接口
    @GetMapping("/majors")
    public ResponseEntity<?> getMajors(@RequestParam(value = "d_no", required = false) String dNo) {
        try {
            List<Major> majors;

            // 如果传递了系别编号，则根据系别编号查询专业
            if (dNo != null && !dNo.isEmpty()) {
                majors = majorService.getMajorsByDept(dNo);  // 新增根据系别编号查询专业的方法
            } else {
                majors = majorService.getAllMajors();  // 如果没有系别编号，则获取所有专业
            }

            return ResponseEntity.ok(new ApiResponse(true, "获取专业列表成功", majors));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "获取专业列表失败", null));
        }
    }
}

package com.dorm.dorm.controller;

import com.dorm.dorm.entity.Dept;
import com.dorm.dorm.respose.ApiResponse;
import com.dorm.dorm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/depts")
    public ResponseEntity<?> getDepts() {
        List<Dept> depts = deptService.getAllDepts();
        if (depts == null || depts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, "没有找到系别信息", null));
        }
        return ResponseEntity.ok(new ApiResponse(true, "获取系别信息成功", depts));
    }
}
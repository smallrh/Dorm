package com.dorm.dorm.controller;

import com.dorm.dorm.entity.Class;
import com.dorm.dorm.respose.ApiResponse;
import com.dorm.dorm.service.ClassService;
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
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/classes")
    public ResponseEntity<?> getClasses(@RequestParam("m_no") String m_no) {
        try {
            List<Class> classes = classService.getClassesByMajor(m_no);
            return ResponseEntity.ok(new ApiResponse(true, "获取班级列表成功", classes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "获取班级列表失败", null));
        }
    }
}

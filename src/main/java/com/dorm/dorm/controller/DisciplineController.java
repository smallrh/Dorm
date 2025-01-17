package com.dorm.dorm.controller;

import com.dorm.dorm.dto.DisciplineDTO;
import com.dorm.dorm.entity.Discipline;
import com.dorm.dorm.request.DisciplineRequest;
import com.dorm.dorm.respose.ApiResponse;
import com.dorm.dorm.respose.ResultResponse;
import com.dorm.dorm.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    // 获取最近三天的违纪记录
    @GetMapping("/discipline/recent")
    public ResponseEntity<ApiResponse> getRecentDisciplinaryRecords() {

        // 获取最近三天的违纪记录
        List<DisciplineDTO> recentDisciplineRecords = disciplineService.getRecentDisciplineRecords();

        if (recentDisciplineRecords == null || recentDisciplineRecords.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "获取违纪记录失败", null));
        }

        return ResponseEntity.ok(new ApiResponse(true, "获取违纪记录成功", recentDisciplineRecords));
    }

    @PostMapping("/MyDiscipline")
    public ResultResponse<List<Discipline>> getMyDisciplineRecords(@RequestBody DisciplineRequest request) {
        List<Discipline> disciplineRecords = disciplineService.getMyDisciplineRecords(request);
        return ResultResponse.success(disciplineRecords, "获取我的违纪记录成功", disciplineRecords.size());
    }
}
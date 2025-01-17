package com.dorm.dorm.controller;

import com.dorm.dorm.dto.FixDTO;
import com.dorm.dorm.entity.Fix;
import com.dorm.dorm.request.FixRequest;
import com.dorm.dorm.respose.ApiResponse;
import com.dorm.dorm.respose.ResultResponse;
import com.dorm.dorm.service.FixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FixController {
    @Autowired
    private FixService fixService;

    @GetMapping("/fix")
    public ResponseEntity<ApiResponse> getRepairRecords() {
        // 获取维修记录
        List<FixDTO> repairRecords = fixService.getRepairRecords();

        if (repairRecords == null || repairRecords.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "获取报修记录失败", null));
        }

        return ResponseEntity.ok(new ApiResponse(true, "获取报修记录成功", repairRecords));
    }

    @GetMapping("/myfix")
    public ResultResponse<?> getFixRecords(@RequestParam("f_rno") String roomNo) {
        try {
            List<Fix> fixRecords = fixService.getFixRecordsByRoomNo(roomNo);
            if (fixRecords != null && !fixRecords.isEmpty()) {
                return ResultResponse.success(fixRecords, "查询成功");
            } else {
                return ResultResponse.error("未找到维修记录");
            }
        } catch (Exception e) {
            return ResultResponse.error("查询失败: " + e.getMessage());
        }
    }

    // 提交维修申请
    @PostMapping("/repair")
    public ResultResponse<?> submitRepair(@RequestBody FixRequest request) {
        try {
            fixService.submitRepair(request);
            return ResultResponse.success("维修申请提交成功");
        } catch (Exception e) {
            return ResultResponse.error("提交失败，请稍后重试");
        }
    }
}

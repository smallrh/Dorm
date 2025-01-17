package com.dorm.dorm.controller;

import com.dorm.dorm.entity.Rs;
import com.dorm.dorm.respose.ApiResponse;
import com.dorm.dorm.respose.ResultResponse;
import com.dorm.dorm.service.RsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RsController {

    @Autowired
    private RsService rsService;

    @GetMapping("/rs")
    public ResultResponse<List<Map<String, Object>>> getRoommates(@RequestParam("sNo") String sNo) {
        List<Map<String, Object>> roommatesInfo = rsService.getRoommatesInfoBySNo(sNo);
        return new ResultResponse<>(roommatesInfo, "Success", 0, roommatesInfo.size());
    }
}

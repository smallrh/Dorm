package com.dorm.dorm.controller;

import com.dorm.dorm.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class InitController {
    @Autowired
    private InitService initService;

    @GetMapping("/init")
    public ResponseEntity<String> init(@RequestParam("s_no") String sNo) {
        String jsonData = initService.getInitData(sNo);
        if (jsonData.contains("Failed") || jsonData.contains("No matching")) {
            return ResponseEntity.badRequest().body(jsonData);
        }
        return ResponseEntity.ok(jsonData);
    }
}

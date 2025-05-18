package com.example.gatewayservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/progress")
    public ResponseEntity<Map<String, Object>> fallbackProgress() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "进度服务当前不可用，请稍后重试。");
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("code", 503);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}
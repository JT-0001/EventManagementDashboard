package com.example.eventdashboard.controller;

import com.example.eventdashboard.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Map<String, Boolean> login(@RequestBody Map<String, String> payload) {
        boolean success = adminService.validateAdmin(payload.get("username"), payload.get("password"));
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", success);
        return response;
    }
}

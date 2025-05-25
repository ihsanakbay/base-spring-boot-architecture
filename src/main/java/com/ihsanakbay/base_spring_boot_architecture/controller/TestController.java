package com.ihsanakbay.base_spring_boot_architecture.controller;

import com.ihsanakbay.base_spring_boot_architecture.dto.response.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @GetMapping("/all")
    public ApiResponse<String> allAccess() {
        return ApiResponse.success("Public Content.");
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ApiResponse<String> userAccess() {
        return ApiResponse.success("User Content.");
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public ApiResponse<String> moderatorAccess() {
        return ApiResponse.success("Moderator Board.");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<String> adminAccess() {
        return ApiResponse.success("Admin Board.");
    }
}

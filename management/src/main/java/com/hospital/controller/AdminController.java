package com.hospital.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.hospital.service.AdminService;
import com.hospital.model.BedAllocation;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/bed-requests")
    public List<BedAllocation> getAllBedRequests() {
        return adminService.getAllBedRequests();
    }

    @PutMapping("/bed-requests/{id}/approve")
    public BedAllocation approveBedRequest(@PathVariable Long id) {
        return adminService.approveBedRequest(id);
    }
}
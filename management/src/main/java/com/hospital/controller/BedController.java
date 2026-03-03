package com.hospital.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.hospital.service.BedService;
import com.hospital.model.Bed;
import com.hospital.model.BedAllocation;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/beds")
@RequiredArgsConstructor
public class BedController {

    private final BedService bedService;

    @GetMapping
    public List<Bed> getAllBeds() {
        return bedService.getAllBeds();
    }

    @PostMapping("/allocate")
    public BedAllocation allocateBed(
            @RequestParam Long bedId,
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        return bedService.allocateBed(bedId, patientId, doctorId, startDate, endDate);
    }
}
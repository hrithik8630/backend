package com.hospital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hospital.model.*;
import com.hospital.model.BedStatus;
import com.hospital.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final BedAllocationRepository bedAllocationRepository;
    private final BedRepository bedRepository;

    @Override
    public List<BedAllocation> getAllBedRequests() {
        return bedAllocationRepository.findAll();
    }

    @Override
    public BedAllocation approveBedRequest(Long id) {

        BedAllocation allocation = bedAllocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        allocation.setStatus(BedStatus.APPROVED);

        Bed bed = allocation.getBed();
        bed.setStatus(BedStatus.APPROVED);

        bedRepository.save(bed);

        return bedAllocationRepository.save(allocation);
    }
}
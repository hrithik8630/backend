package com.hospital.service;

import com.hospital.model.BedAllocation;

import java.util.List;

public interface AdminService {

    List<BedAllocation> getAllBedRequests();

    BedAllocation approveBedRequest(Long id);
}
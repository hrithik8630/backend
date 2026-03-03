package com.hospital.service;

import com.hospital.model.Bed;
import com.hospital.model.BedAllocation;

import java.util.List;

public interface BedService {

    List<Bed> getAllBeds();

    BedAllocation allocateBed(Long bedId,
                              Long patientId,
                              Long doctorId,
                              String startDate,
                              String endDate);
}
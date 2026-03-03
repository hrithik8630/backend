package com.hospital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hospital.model.*;
import com.hospital.repository.*;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BedServiceImpl implements BedService {

    private final BedRepository bedRepository;
    private final BedAllocationRepository bedAllocationRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    @Override
    public BedAllocation allocateBed(Long bedId,
                                     Long patientId,
                                     Long doctorId,
                                     String startDate,
                                     String endDate) {

        Bed bed = bedRepository.findById(bedId)
                .orElseThrow(() -> new RuntimeException("Bed not found"));

        User patient = userRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        BedAllocation allocation = BedAllocation.builder()
                .bed(bed)
                .patient(patient)
                .approvedBy(doctor)
                .startDate(start)
                .endDate(end)
                .status(BedStatus.PENDING)
                .build();

        return bedAllocationRepository.save(allocation);
    }
}
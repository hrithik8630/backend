package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.model.BedAllocation;
import com.hospital.model.Bed;

import java.time.LocalDate;
import java.util.List;

public interface BedAllocationRepository extends JpaRepository<BedAllocation, Long> {

    List<BedAllocation> findByBed(Bed bed);

    List<BedAllocation> findByPatientId(Long patientId);

    List<BedAllocation> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(
            LocalDate endDate,
            LocalDate startDate
    );
}
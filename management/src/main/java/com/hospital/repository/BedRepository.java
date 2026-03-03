package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.model.Bed;
import com.hospital.model.BedStatus;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed, Long> {

    List<Bed> findByStatus(BedStatus status);
}
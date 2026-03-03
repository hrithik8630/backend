package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.model.Doctor;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByUserId(Long userId);
}
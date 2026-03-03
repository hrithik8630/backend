package com.hospital.service;

import com.hospital.model.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();
    Doctor saveDoctor(Doctor doctor);

    Doctor getDoctorById(Long id);

    List<LocalTime> getAvailableSlots(Long doctorId, LocalDate date);
}
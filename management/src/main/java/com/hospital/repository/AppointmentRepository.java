package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctorAndAppointmentDate(Doctor doctor, LocalDate date);

    boolean existsByDoctorAndAppointmentDateAndSlotTime(
            Doctor doctor,
            LocalDate appointmentDate,
            LocalTime slotTime
    );

    List<Appointment> findByPatientId(Long patientId);

    List<Appointment> findByDoctorId(Long doctorId);
}
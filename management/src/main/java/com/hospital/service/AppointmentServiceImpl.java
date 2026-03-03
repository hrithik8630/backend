package com.hospital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.hospital.dto.AppointmentResponseDTO;
import com.hospital.model.*;
import com.hospital.repository.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    // ✅ Book Appointment
    @Override
    public AppointmentResponseDTO bookAppointment(
            Long doctorId,
            Long patientId,
            String date,
            String time) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        User patient = userRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        LocalDate appointmentDate = LocalDate.parse(date);
        LocalTime slotTime = LocalTime.parse(time);

        boolean exists = appointmentRepository
                .existsByDoctorAndAppointmentDateAndSlotTime(
                        doctor, appointmentDate, slotTime);

        if (exists) {
            throw new RuntimeException("Slot already booked");
        }

        Appointment appointment = Appointment.builder()
                .doctor(doctor)
                .patient(patient)
                .appointmentDate(appointmentDate)
                .slotTime(slotTime)
                .status(AppointmentStatus.PENDING)
                .build();

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return convertToResponseDTO(savedAppointment);
    }

    // ✅ Get Appointments by Patient
    @Override
    public List<AppointmentResponseDTO> getAppointmentsByPatient(Long patientId) {

        return appointmentRepository.findByPatientId(patientId)
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    // ✅ Approve Appointment
    @Override
    public AppointmentResponseDTO approveAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(AppointmentStatus.APPROVED);

        Appointment updatedAppointment = appointmentRepository.save(appointment);

        return convertToResponseDTO(updatedAppointment);
    }

    // ✅ Convert Entity → DTO
    private AppointmentResponseDTO convertToResponseDTO(Appointment appointment) {

        return AppointmentResponseDTO.builder()
                .id(appointment.getId())
                .doctorName(
                        appointment.getDoctor()
                                .getUser()
                                .getUsername()
                )
                .patientName(
                        appointment.getPatient()
                                .getUsername()
                )
                .appointmentDate(appointment.getAppointmentDate())
                .slotTime(appointment.getSlotTime())
                .status(appointment.getStatus().name())
                .build();
    }
}
package com.hospital.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.hospital.service.AppointmentService;
import com.hospital.model.Appointment;
import com.hospital.dto.AppointmentRequestDTO;
import com.hospital.dto.AppointmentResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/book")
    public AppointmentResponseDTO bookAppointment(
            @RequestBody AppointmentRequestDTO request) {

        return appointmentService.bookAppointment(
                request.getDoctorId(),
                request.getPatientId(),
                request.getDate(),
                request.getTime()

        );
    }

    @GetMapping("/patient/{patientId}")
    public List<AppointmentResponseDTO> getPatientAppointments(
            @PathVariable Long patientId) {

        return appointmentService.getAppointmentsByPatient(patientId);
    }

    @PutMapping("/{appointmentId}/approve")
    public AppointmentResponseDTO approveAppointment(
            @PathVariable Long appointmentId) {

        return appointmentService.approveAppointment(appointmentId);
    }
}
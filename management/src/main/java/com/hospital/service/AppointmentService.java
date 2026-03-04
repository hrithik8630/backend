package com.hospital.service;

import com.hospital.dto.AppointmentResponseDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentResponseDTO bookAppointment(
            Long doctorId,
            Long patientId,
            String date,
            String time
    );

    List<AppointmentResponseDTO> getAppointmentsByPatient(Long patientId);

    List<AppointmentResponseDTO> getAppointmentsByDoctor(Long doctorId);

    AppointmentResponseDTO approveAppointment(Long appointmentId);
}

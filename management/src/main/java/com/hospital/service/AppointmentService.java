package com.hospital.service;

import com.hospital.dto.AppointmentResponseDTO;
import com.hospital.model.Appointment;

import java.util.List;

public interface AppointmentService {

    AppointmentResponseDTO bookAppointment(
            Long doctorId,
            Long patientId,
            String date,
            String time
    );

    List<AppointmentResponseDTO> getAppointmentsByPatient(Long patientId);

    AppointmentResponseDTO approveAppointment(Long appointmentId);
}
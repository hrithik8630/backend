package com.hospital.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponseDTO {

    private Long id;
    private String doctorName;
    private String patientName;
    private LocalDate appointmentDate;
    private LocalTime slotTime;
    private String status;
}
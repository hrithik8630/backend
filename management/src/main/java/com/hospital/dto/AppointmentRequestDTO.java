package com.hospital.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDTO {

    private Long doctorId;
    private Long patientId;
    private String date;
    private String time;
}
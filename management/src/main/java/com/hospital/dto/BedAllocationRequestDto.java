package com.hospital.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BedAllocationRequestDto {

    private Long bedId;
    private Long patientId;
    private Long doctorId;
    private String startDate;
    private String endDate;
}
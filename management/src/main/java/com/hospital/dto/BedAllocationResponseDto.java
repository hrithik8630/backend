package com.hospital.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BedAllocationResponseDto {

    private Long id;
    private String bedNumber;
    private String patientName;
    private String doctorName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
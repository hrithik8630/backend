package com.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "bed_allocations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BedAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private BedStatus status; 
    // PENDING, APPROVED, REJECTED

    // Many allocations belong to one bed
    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;

    // Many allocations belong to one patient
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;

    // Doctor who approved the bed
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor approvedBy;
}
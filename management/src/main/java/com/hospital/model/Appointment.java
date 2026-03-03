package com.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate appointmentDate;
    private LocalTime slotTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    // Many appointments belong to one doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    // Many appointments belong to one patient
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;
}
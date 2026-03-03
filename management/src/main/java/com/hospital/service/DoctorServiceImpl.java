
package com.hospital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hospital.model.Doctor;
import com.hospital.model.Appointment;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.AppointmentRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    @Override
public Doctor saveDoctor(Doctor doctor) {
    return doctorRepository.save(doctor);
}
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Override
    public List<LocalTime> getAvailableSlots(Long doctorId, LocalDate date) {

        Doctor doctor = getDoctorById(doctorId);

        // Step 1: Generate all slots
        List<LocalTime> allSlots = generateSlots(doctor);

        // Step 2: Get already booked appointments
        List<Appointment> bookedAppointments =
                appointmentRepository.findByDoctorAndAppointmentDate(doctor, date);

        List<LocalTime> bookedSlots = bookedAppointments.stream()
                .map(Appointment::getSlotTime)
                .collect(Collectors.toList());

        // Step 3: Remove booked slots
        return allSlots.stream()
                .filter(slot -> !bookedSlots.contains(slot))
                .collect(Collectors.toList());
    }

    // Slot generation logic using LocalTime
    private List<LocalTime> generateSlots(Doctor doctor) {

        List<LocalTime> slots = new ArrayList<>();

        LocalTime start = doctor.getStartTime();
        LocalTime end = doctor.getEndTime();
        int duration = doctor.getSlotDuration();

        while (start.isBefore(end)) {
            slots.add(start);
            start = start.plusMinutes(duration);
        }

        return slots;
    }
}
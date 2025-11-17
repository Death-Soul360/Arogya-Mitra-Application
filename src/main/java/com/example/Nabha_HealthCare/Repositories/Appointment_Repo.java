package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.DTO.Appointment;
import com.example.Nabha_HealthCare.DTO.Patient;
import com.example.Nabha_HealthCare.DTO.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Appointment_Repo extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);
    List<Appointment> findByPatientIn(List<Patient> patients);
    List<Appointment> findByDoctorIn(List<Doctor> doctors);
}
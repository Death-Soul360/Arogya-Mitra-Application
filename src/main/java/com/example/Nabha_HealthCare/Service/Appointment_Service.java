package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.DTO.Appointment;
import com.example.Nabha_HealthCare.DTO.Doctor;
import com.example.Nabha_HealthCare.DTO.Patient;
import com.example.Nabha_HealthCare.Repositories.Appointment_Repo;
import com.example.Nabha_HealthCare.Repositories.Doctor_Repo;
import com.example.Nabha_HealthCare.Repositories.Patient_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Appointment_Service {

    @Autowired
    private Appointment_Repo appointmentRepo;

    @Autowired
    private Patient_Repo patientRepo;

    @Autowired
    private Doctor_Repo doctorRepo;

    // 1. Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    // 2. Get appointment by ID
    public Appointment getAppointmentById(Integer id) {
        return appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + id));
    }

    // 3. Get by patient name
    public List<Appointment> getAppointmentsByPatient(String patientName) {
        List<Patient> patients = patientRepo.findByName(patientName);
        return appointmentRepo.findByPatientIn(patients);
    }

    // 4. Get by doctor name
    public List<Appointment> getAppointmentsByDoctor(String doctorName) {
        List<Doctor> doctors = doctorRepo.findByName(doctorName);
        return appointmentRepo.findByDoctorIn(doctors);
    }

    // 5. Get by date
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointmentRepo.findByAppointmentDate(date);
    }

    // 6. Add appointment
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    // 7. Update appointment
    public Appointment updateAppointment(Integer id, Appointment updatedAppointment) {
        Appointment appt = getAppointmentById(id);
        appt.setAppointmentDate(updatedAppointment.getAppointmentDate());
        appt.setMode(updatedAppointment.getMode());
        appt.setStatus(updatedAppointment.getStatus());
        appt.setPatient(updatedAppointment.getPatient());
        appt.setDoctor(updatedAppointment.getDoctor());
        return appointmentRepo.save(appt);
    }

    // 8. Delete appointment
    public void deleteAppointment(Integer id) {
        appointmentRepo.deleteById(id);
    }
}

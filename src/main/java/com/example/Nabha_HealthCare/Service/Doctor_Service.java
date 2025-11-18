package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.Entity.Doctor;
import com.example.Nabha_HealthCare.Repositories.Doctor_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Doctor_Service {

    @Autowired
    private Doctor_Repo doctorRepo;

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Optional<Doctor> getDoctorById(Integer id) {
        return doctorRepo.findById(id);
    }

    public List<Doctor> getDoctorsByName(String name) {
        return doctorRepo.findByName(name);
    }

    public List<Doctor> getBySpecialization(String specialization) {
        return doctorRepo.findBySpecialization(specialization);
    }

    public List<Doctor> getByAvailability(String status) {
        return doctorRepo.findByAvailabilityStatus(status);
    }

    public List<Doctor> getByHospital(Integer hospitalId) {
        return doctorRepo.findByHospital_HospitalId(hospitalId);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public Doctor updateDoctor(Integer id, Doctor updatedDoctor) {
        return doctorRepo.findById(id).map(doc -> {
            doc.setName(updatedDoctor.getName());
            doc.setSpecialization(updatedDoctor.getSpecialization());
            doc.setAvailabilityStatus(updatedDoctor.getAvailabilityStatus());
            doc.setHospital(updatedDoctor.getHospital());
            return doctorRepo.save(doc);
        }).orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }

    public void deleteDoctor(Integer id) {
        doctorRepo.deleteById(id);
    }
}

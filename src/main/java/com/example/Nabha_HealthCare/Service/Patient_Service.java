package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.DTO.Patient;
import com.example.Nabha_HealthCare.Repositories.Patient_Repo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Patient_Service {
    @Autowired
    private Patient_Repo patientRepo;

    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public List<Patient> getByName(String name) {
        return patientRepo.findByName(name);
    }

    public Optional<Patient> getById(Integer id) {
        return patientRepo.findById(id);
    }

    public List<Patient> getByAge(Integer age) {
        return patientRepo.findByAge(age);
    }

    public List<Patient> getByGender(String gender) {
        return patientRepo.findByGender(gender);
    }

    public List<Patient> getByPhone(String phone) {
        return patientRepo.findByPhone(phone);
    }

    public List<Patient> getByVillage(String village) {
        return patientRepo.findByVillage(village);
    }

    public void addPatient(Patient patient) {
        patientRepo.save(patient);
    }

    public Patient updatePatient(Integer id, Patient updatedPatient) {
        Optional<Patient> existing = patientRepo.findById(id);
        if (existing.isPresent()) {
            Patient p = existing.get();
            p.setName(updatedPatient.getName());
            p.setAge(updatedPatient.getAge());
            p.setGender(updatedPatient.getGender());
            p.setPhone(updatedPatient.getPhone());
            p.setVillage(updatedPatient.getVillage());
            return patientRepo.save(p);
        } else {
            throw new RuntimeException("Patient not found with ID: " + id);
        }
    }

    @Transactional // Agar yaha koi error hota hai to rollback ho jayega
    public void dischargePatient(String name) {
        patientRepo.deleteByName(name);
    }
}

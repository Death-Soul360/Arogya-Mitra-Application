package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.DTO.Doctor;
import com.example.Nabha_HealthCare.DTO.Hospital;
import com.example.Nabha_HealthCare.DTO.Medicine;
import com.example.Nabha_HealthCare.Repositories.Doctor_Repo;
import com.example.Nabha_HealthCare.Repositories.Hospital_Repo;
import com.example.Nabha_HealthCare.Repositories.Medicine_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Hospital_Service {
    @Autowired
    private Hospital_Repo hospitalRepo;

    @Autowired
    private Doctor_Repo doctorRepo;

    @Autowired
    private Medicine_Repo medicineRepo;

    public List<Hospital> getHospitals() {
        return hospitalRepo.findAll();
    }

    public List<Hospital> hospitalByName(String name) {
        return hospitalRepo.findByName(name);
    }

    public List<Hospital> hospitalByLoc(String location) {
        return hospitalRepo.findByLocation(location);
    }

    public Hospital hospitalById(Integer id) {
        return hospitalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found with ID: " + id));
    }

    public Hospital addHospital(Hospital hospital) {
        return hospitalRepo.save(hospital);
    }

    public Hospital updateHospital(Integer id, Hospital updatedHospital) {
        Hospital hospital = hospitalById(id);
        hospital.setName(updatedHospital.getName());
        hospital.setLocation(updatedHospital.getLocation());
        return hospitalRepo.save(hospital);
    }


    // 🔹 7. Delete hospital
    public void deleteHospital(Integer id) {
        hospitalRepo.deleteById(id);
    }

    // 🔹 8. Get doctors in a hospital
    public List<Doctor> getDoctorsByHospital(Integer id) {
        Hospital hospital = hospitalById(id);
        return doctorRepo.findByHospital(hospital);
    }

    // 🔹 9. Get medicines in a hospital
    public List<Medicine> getMedicinesByHospital(Integer id) {
        Hospital hospital = hospitalById(id);
        return medicineRepo.findByHospital(hospital);
    }
}

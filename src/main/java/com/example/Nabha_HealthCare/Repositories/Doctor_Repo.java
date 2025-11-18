package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Doctor_Repo extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByName(String name);
    List<Doctor> findBySpecialization(String specialization);
    List<Doctor> findByAvailabilityStatus(String availabilityStatus);
    List<Doctor> findByHospital_HospitalId(Integer hospitalId);
}

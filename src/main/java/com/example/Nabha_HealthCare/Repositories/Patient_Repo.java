package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Patient_Repo extends JpaRepository<Patient,Integer> {
    List<Patient> findByName(String name);

    void deleteByName(String name);

    List<Patient> findByAge(Integer age);

    List<Patient> findByGender(String gender);

    List<Patient> findByPhone(String phone);

    List<Patient> findByVillage(String village);

    List<Patient> findByHospital_HospitalId(Long hospitalId);
}

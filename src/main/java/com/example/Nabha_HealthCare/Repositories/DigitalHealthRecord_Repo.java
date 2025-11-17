package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.DTO.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DigitalHealthRecord_Repo extends JpaRepository<DigitalHealthRecord, Integer> {
    List<DigitalHealthRecord> findByFollowUpDate(LocalDate followUpDate);
    List<DigitalHealthRecord> findByPatientIn(List<Patient> patients);
}

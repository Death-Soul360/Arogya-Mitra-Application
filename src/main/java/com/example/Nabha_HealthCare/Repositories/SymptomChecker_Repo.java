package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.DTO.SymptomChecker;
import com.example.Nabha_HealthCare.DTO.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomChecker_Repo extends JpaRepository<SymptomChecker, Integer> {
    List<SymptomChecker> findBySuggestedSpecialistIgnoreCase(String suggestedSpecialist);
    List<SymptomChecker> findByPatientIn(List<Patient> patients);
    List<SymptomChecker> findByReportedSymptoms(String reportedSymptoms);}

package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.Entity.Patient;
import com.example.Nabha_HealthCare.Entity.SymptomChecker;
import com.example.Nabha_HealthCare.Repositories.Patient_Repo;
import com.example.Nabha_HealthCare.Repositories.SymptomChecker_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomChecker_Service {

    @Autowired
    private SymptomChecker_Repo symptomRepo;

    @Autowired
    private Patient_Repo patientRepo;

    public List<SymptomChecker> getAll() {
        return symptomRepo.findAll();
    }

    public SymptomChecker getById(Integer id) {
        return symptomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Symptom not found with ID: " + id));
    }

    public List<SymptomChecker> getByPatient(String name) {
        List<Patient> patients = patientRepo.findByName(name);
        return symptomRepo.findByPatientIn(patients);
    }

    public List<SymptomChecker> bySpecialist(String specialist) {
        return symptomRepo.findBySuggestedSpecialistIgnoreCase(specialist);
    }

    public SymptomChecker addSymptom(SymptomChecker symptom) {
        return symptomRepo.save(symptom);
    }

    public SymptomChecker updateSymptom(Integer id, SymptomChecker updatedSymptom) {
        SymptomChecker existing = getById(id);
        existing.setReportedSymptoms(updatedSymptom.getReportedSymptoms());
        existing.setSuggestedSpecialist(updatedSymptom.getSuggestedSpecialist());
        existing.setPatient(updatedSymptom.getPatient());
        return symptomRepo.save(existing);
    }

    public void deleteSymptom(Integer id) {
        symptomRepo.deleteById(id);
    }

    public List<SymptomChecker> bySymptom(String reportedSymptoms) {
        return symptomRepo.findByReportedSymptoms(reportedSymptoms);
    }
}

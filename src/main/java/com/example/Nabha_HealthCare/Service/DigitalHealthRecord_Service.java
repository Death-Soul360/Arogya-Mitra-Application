package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.DTO.Patient;
import com.example.Nabha_HealthCare.Repositories.DigitalHealthRecord_Repo;
import com.example.Nabha_HealthCare.Repositories.Patient_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DigitalHealthRecord_Service {

    @Autowired
    private DigitalHealthRecord_Repo recordRepo;

    @Autowired
    private Patient_Repo patientRepo;

    // 1️⃣ Get all records
    public List<DigitalHealthRecord> getAllRecords() {
        return recordRepo.findAll();
    }

    // 2️⃣ Get record by ID
    public DigitalHealthRecord getRecordById(Integer id) {
        return recordRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with ID: " + id));
    }

    // 3️⃣ Get records by Patient Name
    public List<DigitalHealthRecord> getRecordsByPatientName(String name) {
        List<Patient> patients = patientRepo.findByName(name);
        return recordRepo.findByPatientIn(patients);
    }

    // 4️⃣ Get records by Follow-Up Date
    public List<DigitalHealthRecord> getRecordsByFollowUpDate(LocalDate followUpDate) {
        return recordRepo.findByFollowUpDate(followUpDate);
    }

    // 5️⃣ Add record
    public DigitalHealthRecord addRecord(DigitalHealthRecord record) {
        return recordRepo.save(record);
    }

    // 6️⃣ Update record
    public DigitalHealthRecord updateRecord(Integer id, DigitalHealthRecord updatedRecord) {
        DigitalHealthRecord record = getRecordById(id);
        record.setDiagnosis(updatedRecord.getDiagnosis());
        record.setPrescription(updatedRecord.getPrescription());
        record.setFollowUpDate(updatedRecord.getFollowUpDate());
        record.setPatient(updatedRecord.getPatient());
        return recordRepo.save(record);
    }

    // 7️⃣ Delete record
    public void deleteRecord(Integer id) {
        recordRepo.deleteById(id);
    }
}

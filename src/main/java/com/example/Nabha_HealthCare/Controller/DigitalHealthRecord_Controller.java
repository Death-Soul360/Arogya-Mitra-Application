package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.Service.DigitalHealthRecord_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/record")
public class DigitalHealthRecord_Controller {

    @Autowired
    private DigitalHealthRecord_Service recordService;

    // 1️⃣ Get all records
    @GetMapping("/all")
    public List<DigitalHealthRecord> getAllRecords() {
        return recordService.getAllRecords();
    }

    // 2️⃣ Get by ID
    @GetMapping("/byId/{id}")
    public DigitalHealthRecord getById(@PathVariable Integer id) {
        return recordService.getRecordById(id);
    }

    // 3️⃣ Get by Patient Name
    @GetMapping("/byPatient")
    public List<DigitalHealthRecord> getByPatientName(@RequestParam String name) {
        return recordService.getRecordsByPatientName(name);
    }

    // 4️⃣ Get by Follow-Up Date
    @GetMapping("/byFollowUpDate")
    public List<DigitalHealthRecord> getByFollowUpDate(@RequestParam String date) {
        LocalDate followUp = LocalDate.parse(date);
        return recordService.getRecordsByFollowUpDate(followUp);
    }

    // 5️⃣ Add new record
    @PostMapping("/add")
    public DigitalHealthRecord addRecord(@RequestBody DigitalHealthRecord record) {
        return recordService.addRecord(record);
    }

    // 6️⃣ Update record
    @PutMapping("/update/{id}")
    public DigitalHealthRecord updateRecord(@PathVariable Integer id, @RequestBody DigitalHealthRecord updatedRecord) {
        return recordService.updateRecord(id, updatedRecord);
    }

    // 7️⃣ Delete record
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable Integer id) {
        recordService.deleteRecord(id);
    }
}

package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.Entity.Patient;
import com.example.Nabha_HealthCare.Service.Patient_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class Patient_Controller {

    @Autowired
    private Patient_Service patientService;

    // Get all patients
    @GetMapping("/all")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/byId/{id}")
    public Optional<Patient> getById(@PathVariable Integer id) {
        return patientService.getById(id);
    }

    @GetMapping("/byName")
    public List<Patient> getByName(@RequestParam String name) {
        return patientService.getByName(name);
    }

    @GetMapping("/byAge")
    public List<Patient> getByAge(@RequestParam Integer age) {
        return patientService.getByAge(age);
    }

    @GetMapping("/byGender")
    public List<Patient> getByGender(@RequestParam String gender) {
        return patientService.getByGender(gender);
    }

    @GetMapping("/byPhone")
    public List<Patient> getByPhone(@RequestParam String phone) {
        return patientService.getByPhone(phone);
    }

    @GetMapping("/byVillage")
    public List<Patient> getByVillage(@RequestParam String village) {
        return patientService.getByVillage(village);
    }

    @PostMapping("/add")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Integer id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/discharge")
    public void dischargePatient(@RequestParam String name) {
        patientService.dischargePatient(name);
    }
}

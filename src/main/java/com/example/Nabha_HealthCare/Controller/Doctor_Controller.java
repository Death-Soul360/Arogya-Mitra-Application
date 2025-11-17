package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.DTO.Doctor;
import com.example.Nabha_HealthCare.Service.Doctor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class Doctor_Controller {

    @Autowired
    private Doctor_Service doctorService;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/byId/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/byName")
    public List<Doctor> getDoctorsByName(@RequestParam String name) {
        return doctorService.getDoctorsByName(name);
    }

    @GetMapping("/bySpecialization")
    public List<Doctor> getBySpecialization(@RequestParam String specialization) {
        return doctorService.getBySpecialization(specialization);
    }

    @GetMapping("/byAvailability")
    public List<Doctor> getByAvailability(@RequestParam String status) {
        return doctorService.getByAvailability(status);
    }

    @GetMapping("/byHospital/{hospitalId}")
    public List<Doctor> getByHospital(@PathVariable Integer hospitalId) {
        return doctorService.getByHospital(hospitalId);
    }

    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @PutMapping("/update/{id}")
    public Doctor updateDoctor(@PathVariable Integer id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }
}

package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.DTO.Doctor;
import com.example.Nabha_HealthCare.DTO.Hospital;
import com.example.Nabha_HealthCare.DTO.Medicine;
import com.example.Nabha_HealthCare.Service.Hospital_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class Hospital_Controller {

    @Autowired
    private Hospital_Service hospitalService;

    // 1. Get all hospitals
    @GetMapping("/all")
    public List<Hospital> getHospitals() {
        return hospitalService.getHospitals();
    }

    // 2. Get by ID
    @GetMapping("/byId/{id}")
    public Hospital hospitalById(@PathVariable Integer id) {
        return hospitalService.hospitalById(id);
    }

    // 3. Get by Name
    @GetMapping("/byName")
    public List<Hospital> hospitalByName(@RequestParam String name) {
        return hospitalService.hospitalByName(name);
    }

    // 4. Get by Location
    @GetMapping("/byLocation")
    public List<Hospital> hospitalByLoc(@RequestParam String loc) {
        return hospitalService.hospitalByLoc(loc);
}
    // 5. Add new hospital
    @PostMapping("/add")
    public Hospital addHospital(@RequestBody Hospital hospital) {
        return hospitalService.addHospital(hospital);
    }

    // 6. Update hospital
    @PutMapping("/update/{id}")
    public Hospital updateHospital(@PathVariable Integer id, @RequestBody Hospital hospital) {
        return hospitalService.updateHospital(id, hospital);
    }

    // 7. Delete hospital
    @DeleteMapping("/delete/{id}")
    public void deleteHospital(@PathVariable Integer id) {
        hospitalService.deleteHospital(id);
    }

    // 8. Get doctors in a hospital
    @GetMapping("/{id}/doctors")
    public List<Doctor> getDoctorsByHospital(@PathVariable Integer id) {
        return hospitalService.getDoctorsByHospital(id);
    }

    // 9. Get medicines in a hospital
    @GetMapping("/{id}/medicines")
    public List<Medicine> getMedicinesByHospital(@PathVariable Integer id) {
        return hospitalService.getMedicinesByHospital(id);
    }
}

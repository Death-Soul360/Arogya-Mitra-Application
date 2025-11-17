package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.DTO.Medicine;
import com.example.Nabha_HealthCare.Service.Medicine_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicines")
@CrossOrigin("*")
public class Medicine_Controller {

    @Autowired
    private Medicine_Service medicineService;

    // Add Medicine
    @PostMapping("/add")
    public void add(@RequestBody Medicine request) {
        medicineService.addMedicine(request);
    }

    // Get All Medicines
    @GetMapping("/all")
    public ResponseEntity<List<Medicine>> getAll() {
        return ResponseEntity.ok(medicineService.getAll());
    }

    // Get Single Medicine
    @GetMapping("/{id}")
    public Optional<Medicine> getMedById(@PathVariable Long id) {
        return medicineService.getMedById(id);
    }

    // Update Medicine
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Medicine request) {
         medicineService.update(id, request);
    }

    // Delete Medicine
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        medicineService.delete(id);
        return ResponseEntity.ok("Medicine deleted successfully");
    }

    // Search By Disease
    @GetMapping("/disease/{disease}")
    public Optional<Medicine> byDisease(@PathVariable String disease) {
        return medicineService.findByDisease(disease);
    }

    // Search By Name
    @GetMapping("/search")
    public Optional<Medicine> searchByName(@RequestParam String name) {
        return medicineService.searchByName(name);
    }
}

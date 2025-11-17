package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.DTO.SymptomChecker;
import com.example.Nabha_HealthCare.Service.SymptomChecker_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SymptomChecker_Controller {

    @Autowired
    private SymptomChecker_Service symptomCheckerService;

    @GetMapping("/all")
    public List<SymptomChecker> getAll(){
        return symptomCheckerService.getAll();
    }

    @GetMapping("/{id}")
    public SymptomChecker getById(@PathVariable Integer id){
        return symptomCheckerService.getById(id);
    }

    @GetMapping("/byPatient")
    public List<SymptomChecker> getByPatient(@RequestParam String name){
        return symptomCheckerService.getByPatient(name);
    }

    @GetMapping("/bySymptoms")
    public List<SymptomChecker> bySymptom(@RequestParam String name){
        return symptomCheckerService.bySymptom(name);
    }

    @GetMapping("/bySpecialist")
    public List<SymptomChecker> bySpecialist(@RequestParam String name){
        return symptomCheckerService.bySpecialist(name);
    }

    @PostMapping("/add")
    public SymptomChecker addSymptom(@RequestBody SymptomChecker symptom) {
        return symptomCheckerService.addSymptom(symptom);
    }

    @PutMapping("/update/{id}")
    public SymptomChecker updateSymptom(@PathVariable Integer id, @RequestBody SymptomChecker updatedSymptom) {
        return symptomCheckerService.updateSymptom(id, updatedSymptom);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSymptom(@PathVariable Integer id) {
        symptomCheckerService.deleteSymptom(id);
    }
}

package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.DTO.Medicine;
import com.example.Nabha_HealthCare.Repositories.Medicine_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Medicine_Service {

    @Autowired
    private Medicine_Repo medicineRepository;

    // Add Medicine
    public void addMedicine(Medicine request) {
        medicineRepository.save(request);
    }

    // Get All Medicines
    public List<Medicine> getAll() {
        return medicineRepository.findAll()
                .stream()
                .map(m -> new Medicine(
                        m.getMedicineId(), m.getName(), m.getSalts(), m.getIngredients(),
                        m.getPrice(), m.getDisease(), m.getExpiryDate(), m.getCategory(),m.getManufacturer()
                )).toList();
    }

    // Get One Medicine
    public Optional<Medicine> getMedById(Long id) {
        return medicineRepository.findById(Math.toIntExact(id));


    }

    // Update Medicine
    public void update(Long id, Medicine req) {
        Medicine m = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        m.setName(req.getName());
        m.setSalts(req.getSalts());
        m.setIngredients(req.getIngredients());
        m.setPrice(req.getPrice());
        m.setDisease(req.getDisease());
        m.setExpiryDate(req.getExpiryDate());
        m.setCategory(req.getCategory());

        Medicine saved = medicineRepository.save(m);
    }

    // Delete Medicine
    public void delete(Long id) {
        medicineRepository.deleteById(Math.toIntExact(id));
    }

    // Search By Disease
    public Optional<Medicine> findByDisease(String disease) {
        return medicineRepository.findByDisease(disease);
    }

    // Search By Name
    public Optional<Medicine> searchByName(String name) {
        return medicineRepository.findByNameContainingIgnoreCase(name);
    }
}

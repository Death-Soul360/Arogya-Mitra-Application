package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.DTO.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Hospital_Repo extends JpaRepository<Hospital,Integer> {
    List<Hospital> findByName(String name);
    List<Hospital> findByLocation(String location);
}

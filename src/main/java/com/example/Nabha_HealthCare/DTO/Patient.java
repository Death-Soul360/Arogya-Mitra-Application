package com.example.Nabha_HealthCare.DTO;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String disease;
    private Integer age;


    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;


    @OneToMany(mappedBy="patient")
    private List<Appointment> appointments;
}
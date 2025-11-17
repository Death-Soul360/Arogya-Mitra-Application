package com.example.Nabha_HealthCare.DTO;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String name;
    private String gender;
    private String qualification;
    private String email;
    private String password;
    private String specialist;
    private Double fees;
    private Integer age;


    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;


    @OneToMany(mappedBy="doctor")
    private List<Appointment> appointments;
}
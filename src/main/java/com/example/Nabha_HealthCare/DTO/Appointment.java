package com.example.Nabha_HealthCare.DTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;


    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;


    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String appointmentSlot;
    private Double fees;
    private String status;
}
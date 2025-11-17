package com.example.Nabha_HealthCare.DTO;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;
    private String name;
    private String address;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="admin_id")
    private User admin;
}
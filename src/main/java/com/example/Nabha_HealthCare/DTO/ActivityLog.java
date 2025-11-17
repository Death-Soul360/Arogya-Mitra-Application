package com.example.Nabha_HealthCare.DTO;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activity_log")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    private String action;
    private LocalDateTime logTime;
}
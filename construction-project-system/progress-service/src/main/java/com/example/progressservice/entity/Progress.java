package com.example.progressservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.Data;

@Data
@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;
    private String stage;
    private String status;
    private LocalDate date;
}
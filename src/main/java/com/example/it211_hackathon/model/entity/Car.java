package com.example.it211_hackathon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String brand;
    private Double price;
    @Enumerated(EnumType.STRING)
    private EnumStatus status;
    @Column(name = "is_deleted")
    private boolean isDeleted;
}

package com.example.it211_hackathon.repository;

import com.example.it211_hackathon.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}

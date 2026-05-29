package com.example.it211_hackathon.service;

import com.example.it211_hackathon.model.dto.request.CarDTO;
import com.example.it211_hackathon.model.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car addCar(CarDTO carDTO);
    Car updateCar(Long id, CarDTO carDTO);
    Car patchCar(Long id, CarDTO carDTO);
    void deleteById(Long id);
}

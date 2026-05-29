package com.example.it211_hackathon.service.impl;

import com.example.it211_hackathon.exception.ResourceNotFoundException;
import com.example.it211_hackathon.model.dto.request.CarDTO;
import com.example.it211_hackathon.model.entity.Car;
import com.example.it211_hackathon.model.entity.EnumStatus;
import com.example.it211_hackathon.repository.CarRepository;
import com.example.it211_hackathon.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public Car addCar(CarDTO carDTO) {
        Car car = Car.builder()
                .model(carDTO.getModel())
                .brand(carDTO.getBrand())
                .price(carDTO.getPrice())
                .status(EnumStatus.AVAILABLE)
                .isDeleted(false)
                .build();
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public Car updateCar(Long id, CarDTO carDTO) {
        Car existing = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy xe với ID: " + id));

        existing.setModel(carDTO.getModel());
        existing.setBrand(carDTO.getBrand());
        existing.setPrice(carDTO.getPrice());
        existing.setStatus(EnumStatus.AVAILABLE);
        existing.setDeleted(false);

        return carRepository.save(existing);
    }

    @Override
    @Transactional
    public Car patchCar(Long id, CarDTO carDTO) {
        Car existing = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy xe với ID: " + id));

        if (carDTO.getModel() != null) {
            existing.setModel(carDTO.getModel());
        }
        if (carDTO.getBrand() != null) {
            existing.setBrand(carDTO.getBrand());
        }
        if (carDTO.getPrice() != null) {
            existing.setPrice(carDTO.getPrice());
        }

        return carRepository.save(existing);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!carRepository.existsById(id)) {
            throw new ResourceNotFoundException("Không tìm thấy xe với ID: " + id);
        }
        carRepository.deleteById(id);
    }
}

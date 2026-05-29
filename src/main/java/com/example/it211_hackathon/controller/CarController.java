package com.example.it211_hackathon.controller;

import com.example.it211_hackathon.model.dto.request.CarDTO;
import com.example.it211_hackathon.model.dto.response.ApiDataResponse;
import com.example.it211_hackathon.model.entity.Car;
import com.example.it211_hackathon.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Car>>> getAllCars() {
        List<Car> cars = carService.findAll();
        return ResponseEntity.ok(new ApiDataResponse<>(true, "Lấy danh sách xe thành công", cars));
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Car>> addCar(@Valid @RequestBody CarDTO carDTO) {
        Car saved = carService.addCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiDataResponse<>(true, "Thêm xe thành công", saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Car>> updateCar(
            @PathVariable Long id, @Valid @RequestBody CarDTO carDTO) {
        Car updated = carService.updateCar(id, carDTO);
        return ResponseEntity.ok(new ApiDataResponse<>(true, "Cập nhật xe thành công", updated));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Car>> patchCar(
            @PathVariable Long id, @RequestBody CarDTO carDTO) {
        Car updated = carService.patchCar(id, carDTO);
        return ResponseEntity.ok(new ApiDataResponse<>(true, "Cập nhật một phần thông tin xe thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Void>> deleteById(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.ok(new ApiDataResponse<>(true, "Xóa xe thành công", null));
    }
}

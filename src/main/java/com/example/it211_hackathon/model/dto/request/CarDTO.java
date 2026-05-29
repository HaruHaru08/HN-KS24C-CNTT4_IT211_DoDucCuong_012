package com.example.it211_hackathon.model.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
    @NotBlank(message = "Tên xe không được để trống")
    private String model;
    @NotBlank(message = "Hãng sản xuất không được để trống")
    private String brand;
    @DecimalMin(value = "0.01",message = "Giá tiền phải lớn hơn 0")
    private Double price;
}

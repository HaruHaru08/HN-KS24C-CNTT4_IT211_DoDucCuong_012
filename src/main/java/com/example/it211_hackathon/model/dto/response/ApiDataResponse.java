package com.example.it211_hackathon.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiDataResponse <T>{
    private boolean success;
    private String message;
    private T data;
}

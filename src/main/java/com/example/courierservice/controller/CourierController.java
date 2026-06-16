package com.example.courierservice.controller;

import com.example.courierservice.dto.CourierRequestDto;
import com.example.courierservice.dto.CourierResponseDto;
import com.example.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/couriers")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @PostMapping
    public ResponseEntity<CourierResponseDto> createCourier(@RequestBody CourierRequestDto request) {
        return ResponseEntity.ok(courierService.createCourier(request));
    }

    @GetMapping("/available")
    public ResponseEntity<CourierResponseDto> getAvailableCourier() {
        return ResponseEntity.ok(courierService.getAvailableCourier());
    }
}
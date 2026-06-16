package com.example.courierservice.service;

import com.example.courierservice.dto.CourierRequestDto;
import com.example.courierservice.dto.CourierResponseDto;
import com.example.courierservice.entity.Courier;
import com.example.courierservice.enums.CourierStatus;
import com.example.courierservice.exception.CourierNotFoundException;
import com.example.courierservice.exception.NoAvailableCourierException;
import com.example.courierservice.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;

    public CourierResponseDto createCourier(CourierRequestDto request) {
        Courier courier = Courier.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .status(CourierStatus.FREE)
                .createdAt(LocalDateTime.now())
                .build();

        Courier saved = courierRepository.save(courier);
        return mapToResponse(saved);
    }

    public CourierResponseDto getAvailableCourier() {
        Courier courier = courierRepository.findFirstByStatus(CourierStatus.FREE)
                .orElseThrow(() -> new NoAvailableCourierException());
        return mapToResponse(courier);
    }

    public void updateCourierStatus(Long courierId, CourierStatus status) {
        Courier courier = courierRepository.findById(courierId)
                .orElseThrow(() -> new CourierNotFoundException(courierId));
        courier.setStatus(status);
        courierRepository.save(courier);
    }

    private CourierResponseDto mapToResponse(Courier courier) {
        return CourierResponseDto.builder()
                .id(courier.getId())
                .name(courier.getName())
                .phone(courier.getPhone())
                .status(courier.getStatus())
                .createdAt(courier.getCreatedAt())
                .build();
    }
}
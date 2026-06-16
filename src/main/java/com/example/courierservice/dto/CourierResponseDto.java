package com.example.courierservice.dto;

import com.example.courierservice.enums.CourierStatus;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class CourierResponseDto {
    private Long id;
    private String name;
    private String phone;
    private CourierStatus status;
    private LocalDateTime createdAt;
}
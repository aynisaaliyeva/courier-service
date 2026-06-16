package com.example.courierservice.entity;

import com.example.courierservice.enums.CourierStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "couriers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

    @Enumerated(EnumType.STRING)
    private CourierStatus status;

    private LocalDateTime createdAt;
}
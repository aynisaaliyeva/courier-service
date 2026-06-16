package com.example.courierservice.repository;

import com.example.courierservice.entity.Courier;
import com.example.courierservice.enums.CourierStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
    Optional<Courier> findFirstByStatus(CourierStatus status);
}
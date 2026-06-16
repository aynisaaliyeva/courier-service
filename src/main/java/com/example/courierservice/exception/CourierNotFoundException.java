package com.example.courierservice.exception;

public class CourierNotFoundException extends RuntimeException {
    public CourierNotFoundException(Long id) {
        super("Courier not found with id: " + id);
    }
}
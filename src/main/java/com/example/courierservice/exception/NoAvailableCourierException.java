package com.example.courierservice.exception;

public class NoAvailableCourierException extends RuntimeException {
    public NoAvailableCourierException() {
        super("No available courier found");
    }
}
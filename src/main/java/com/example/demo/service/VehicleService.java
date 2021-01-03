package com.example.demo.service;

import com.example.demo.model.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    Vehicle getVehicleById(UUID id);

    void removeById(UUID id);

    List<Vehicle> getAllVehicle();

}

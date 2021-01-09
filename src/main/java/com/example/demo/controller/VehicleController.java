package com.example.demo.controller;

import com.example.demo.dto.request.CreateVehicleRequest;
import com.example.demo.dto.VehicleDto;
import com.example.demo.mapper.VehicleMapper;
import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicle")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody CreateVehicleRequest vehicleRequest) {
        Vehicle vehicle = vehicleService.save(VehicleMapper.INSTANCE.toModel(vehicleRequest));
        return ResponseEntity.ok(VehicleMapper.INSTANCE.toDto(vehicle));
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable UUID id) {
        return ResponseEntity.ok(VehicleMapper.INSTANCE.toDto(vehicleService.getVehicleById(id)));
    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<Void> deleteVehicleById(@PathVariable UUID id) {
        vehicleService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/vehicle")
    public ResponseEntity<List<VehicleDto>> getAllVehicle() {
        return ResponseEntity.ok(VehicleMapper.INSTANCE.toDto(vehicleService.getAllVehicle()));
    }

}

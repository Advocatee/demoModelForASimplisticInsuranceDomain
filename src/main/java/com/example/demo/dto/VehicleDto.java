package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class VehicleDto {

    private int year;
    private String typeOfTransport;
    private BigDecimal price;
    private UUID vehicleId;
}

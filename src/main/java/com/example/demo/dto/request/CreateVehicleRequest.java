package com.example.demo.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateVehicleRequest {

    private int year;
    private String typeOfTransport;
    private BigDecimal price;
}

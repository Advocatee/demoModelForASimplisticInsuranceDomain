package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CreatePropertyDto {

    private UUID id;
    private int year;
    private int floorAmount;
    private BigDecimal price;

}

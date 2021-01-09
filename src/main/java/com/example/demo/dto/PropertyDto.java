package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyDto extends BaseInsuredDto {

    private int year;
    private int floorAmount;
    private BigDecimal price;
}

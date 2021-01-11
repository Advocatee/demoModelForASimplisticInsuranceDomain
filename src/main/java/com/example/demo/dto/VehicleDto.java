package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDto extends BaseInsuredDto {

    private int year;
    private String typeOfTransport;
    private BigDecimal price;
    private UUID vehicleId;
}

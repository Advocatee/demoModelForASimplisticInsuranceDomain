package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyDto extends BaseInsuredDto {

    private int year;
    private int floorAmount;
    private BigDecimal price;
}

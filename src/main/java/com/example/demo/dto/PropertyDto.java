package com.example.demo.dto;

import com.example.demo.model.PropertyPolicy;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class PropertyDto extends BaseInsuredDto {

    private int year;
    private int floorAmount;
    private BigDecimal price;
    private List<PropertyPolicy> policies = new ArrayList<>();

}

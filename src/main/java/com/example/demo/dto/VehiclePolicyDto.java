package com.example.demo.dto;

import com.example.demo.model.CoverageType;
import com.example.demo.model.Vehicle;
import lombok.Data;

@Data
public class VehiclePolicyDto extends BasePolicyDto {

    private CoverageType coverageType;
    private Vehicle vehicle;

}

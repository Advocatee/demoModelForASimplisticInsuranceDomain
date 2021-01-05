package com.example.demo.dto;

import com.example.demo.model.CoverageType;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CreateContractRequest {

    private String phoneNumber;
    private Date dateOfInformation;
    private CoverageType coverageType;
    private UUID clientId;
    private UUID vehicleId;
}

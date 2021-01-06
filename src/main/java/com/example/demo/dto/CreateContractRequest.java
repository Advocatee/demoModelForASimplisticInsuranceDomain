package com.example.demo.dto;

import com.example.demo.model.CoverageType;
import com.example.demo.model.PropertyPolicy;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.UUID;

@Data
public class CreateContractRequest {

    private String phoneNumber;
    private Date dateOfInformation;
    private CoverageType coverageType;
    private UUID clientId;
    private UUID vehicleId;
    private Date policyExpirationDate;
    @Enumerated(EnumType.STRING)
    private PropertyPolicy propertyPolicy;
}

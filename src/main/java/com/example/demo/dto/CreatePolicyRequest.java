package com.example.demo.dto;

import com.example.demo.model.CoverageType;
import com.example.demo.model.PropertyPolicyType;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.UUID;

@Data
public class CreatePolicyRequest {

    private String phoneNumber;
    private Date dateOfInformation;
    private CoverageType coverageType;
    private UUID clientId;
    private UUID vehicleId;
    private Date policyExpirationDate;
    private String policyType;

}

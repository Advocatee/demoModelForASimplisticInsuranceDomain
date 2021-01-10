package com.example.demo.dto;

import com.example.demo.model.CoverageType;
import com.example.demo.model.PropertyPolicyType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class PolicyDto {

    private UUID id;
    private String phoneNumber;
    private Date dateOfInformation;
    @JsonIgnore
    private CoverageType coverageType;
    private Date policyExpirationDate;
    @JsonIgnore
    private PropertyPolicyType policyType;

}

package com.example.demo.dto;

import com.example.demo.model.CoverageType;
import com.example.demo.model.PropertyPolicyType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyDto {

    private UUID id;
    private String phoneNumber;
    private Date dateOfInformation;
    private CoverageType coverageType;
    private Date policyExpirationDate;
    private PropertyPolicyType policyType;

}

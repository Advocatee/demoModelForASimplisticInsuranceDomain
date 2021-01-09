package com.example.demo.dto.request;

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
    @Nullable
    private CoverageType coverageType;
    @Nullable
    private PropertyPolicyType propertyPolicyType;
    private UUID clientId;
    @Nullable
    private UUID vehicleId;
    @Nullable
    private UUID propertyId;
    private Date policyExpirationDate;
    private String policyType;

}

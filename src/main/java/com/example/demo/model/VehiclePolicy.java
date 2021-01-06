package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("vehicle-policy")
public class VehiclePolicy extends BasePolicy {

    @Enumerated(EnumType.STRING)
    private CoverageType coverageType;

}
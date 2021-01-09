package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("vehicle-policy")
public class VehiclePolicy extends BasePolicy {

    @Enumerated(EnumType.STRING)
    private CoverageType coverageType;
    @ManyToOne()
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
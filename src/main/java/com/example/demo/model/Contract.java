package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Contract extends BaseEntity {

    // TODO rename this class in Policy

    private String phoneNumber;
    private Date dateOfInformation;
    @Enumerated(EnumType.STRING)
    private CoverageType coverageType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    private Date policyExpirationDate;

    @Override
    public String toString() {
        return "Contract{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", dateOfInformation=" + dateOfInformation +
                ", coverageType=" + coverageType +
                ", policyExpirationDate=" + policyExpirationDate +
                '}';
    }
}
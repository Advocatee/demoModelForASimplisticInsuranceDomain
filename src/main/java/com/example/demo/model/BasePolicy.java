package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class BasePolicy extends BaseEntity {

    private String phoneNumber;
    private Date dateOfInformation;
    private Date policyExpirationDate;
    @Enumerated(EnumType.STRING)
    private CoverageType coverageType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

}

package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="base_policy",
        discriminatorType = DiscriminatorType.STRING)
public class BasePolicy extends BaseEntity {

    private String phoneNumber;
    private Date dateOfInformation;
    private Date policyExpirationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

}

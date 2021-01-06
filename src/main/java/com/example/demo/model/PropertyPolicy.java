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
@DiscriminatorValue("property-policy")
public class PropertyPolicy extends BasePolicy {

    @Enumerated(EnumType.STRING)
    private PropertyPolicyType policyType;
}

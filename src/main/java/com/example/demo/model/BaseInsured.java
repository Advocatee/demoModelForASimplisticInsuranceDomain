package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="base_insured",
        discriminatorType = DiscriminatorType.STRING)
public class BaseInsured extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "vehicle")
    private List<Contract> contracts = new ArrayList<>();
}
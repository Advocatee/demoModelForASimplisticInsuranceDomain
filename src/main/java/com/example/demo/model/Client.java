package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Client extends BaseEntity {

    private String fullName;
    private Date dateOfBirth;
    private String emailAddress;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Vehicle> vehicle = new ArrayList<>();
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Contract> contract = new ArrayList<>();
}

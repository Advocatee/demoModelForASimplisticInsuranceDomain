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
public class Clients extends BaseEntity {

    private String fullName;
    private Date dateOfBirth;
    private String emailAddress;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "PEOPLE_TRANSPORT", joinColumns = {@JoinColumn(name = "PEOPLE_ID", referencedColumnName = "id")}
            , inverseJoinColumns = {@JoinColumn(name = "TRANSPORT_ID", referencedColumnName = "id")})
    private List<Vehicle> vehicles = new ArrayList<>();

}

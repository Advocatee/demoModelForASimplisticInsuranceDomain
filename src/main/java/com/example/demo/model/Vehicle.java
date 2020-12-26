package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Vehicle extends BaseEntity {

    private int year;
    private String typeOfTransport;
    private double price;
    @ManyToMany(mappedBy = "vehicles", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Clients> clientsList = new ArrayList<>();

}

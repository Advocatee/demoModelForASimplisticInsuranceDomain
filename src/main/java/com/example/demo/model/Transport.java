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
public class Transport extends BaseEntity {

    private int year;
    private String typeOfTransport;
    private double price;
    @ManyToMany(mappedBy = "transports", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<People> peopleList = new ArrayList<>();

}

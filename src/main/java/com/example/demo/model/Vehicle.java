package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity

public class Vehicle extends BaseEntity {

    private int year;
    private String typeOfTransport;
    private BigDecimal price;
    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "vehicle")
    private List<Contract> contracts = new ArrayList<>();

    @Override
    public String toString() {
        return "Vehicle{" +
                "year=" + year +
                ", typeOfTransport='" + typeOfTransport + '\'' +
                ", price=" + price +
                '}';
    }

}
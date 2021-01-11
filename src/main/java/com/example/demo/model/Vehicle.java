package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("vehicle-insured")
public class Vehicle extends BaseInsured {

    private int year;
    private String typeOfTransport;
    private BigDecimal price;
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<VehiclePolicy> vehiclePolicy = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public String toString() {
        return "Vehicle{" +
                "year=" + year +
                ", typeOfTransport='" + typeOfTransport + '\'' +
                ", price=" + price +
                '}';
    }

}
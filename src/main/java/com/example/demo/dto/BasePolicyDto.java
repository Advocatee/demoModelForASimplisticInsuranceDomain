package com.example.demo.dto;

import com.example.demo.model.Client;
import lombok.Data;

import java.util.Date;

@Data
public class BasePolicyDto {

    private String phoneNumber;
    private Date dateOfInformation;
    private Date policyExpirationDate;
    private Client client;

}
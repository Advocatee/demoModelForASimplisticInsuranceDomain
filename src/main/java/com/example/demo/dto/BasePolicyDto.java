package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BasePolicyDto {

    private String phoneNumber;
    private Date dateOfInformation;
    private Date policyExpirationDate;
    private ClientDto client;

}

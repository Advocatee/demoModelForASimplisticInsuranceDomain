package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClientDto {

    private String fullName;
    private Date dateOfBirth;
    private String emailAddress;

}

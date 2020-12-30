package com.example.demo.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ClientDto {

    private String fullName;
    private Date dateOfBirth;
    private String emailAddress;
    private UUID userID;

}

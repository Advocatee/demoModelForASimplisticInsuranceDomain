package com.example.demo.dto.request;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.UUID;

@Data
public class CreateClientRequest {

    private String fullName;
    private Date dateOfBirth;
    private String emailAddress;
    @Nullable
    private UUID vehicleId;

}
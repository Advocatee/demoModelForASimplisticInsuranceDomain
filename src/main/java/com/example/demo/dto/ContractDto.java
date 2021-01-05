package com.example.demo.dto;

import com.example.demo.model.CoverageType;
import lombok.Data;

import java.util.Date;

@Data
public class ContractDto {

    private String phoneNumber;
    private Date dateOfInformation;
    private CoverageType coverageType;

}

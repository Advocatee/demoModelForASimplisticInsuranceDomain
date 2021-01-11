package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseInsuredDto {

    private ClientDto client;
    private List<BasePolicyDto> policies = new ArrayList<>();
}

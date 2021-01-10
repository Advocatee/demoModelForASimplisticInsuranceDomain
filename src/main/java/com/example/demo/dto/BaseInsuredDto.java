package com.example.demo.dto;

import com.example.demo.model.BasePolicy;
import com.example.demo.model.Client;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseInsuredDto {

    private ClientDto client;
    private List<BasePolicyDto> policies = new ArrayList<>();
}

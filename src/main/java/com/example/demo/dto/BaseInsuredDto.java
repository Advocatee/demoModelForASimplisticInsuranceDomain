package com.example.demo.dto;

import com.example.demo.model.Client;
import com.example.demo.model.Policy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseInsuredDto {

    private Client client;
    private List<Policy> policies = new ArrayList<>();
}

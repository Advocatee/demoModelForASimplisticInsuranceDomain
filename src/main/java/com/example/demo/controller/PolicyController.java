package com.example.demo.controller;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.CreatePolicyRequest;
import com.example.demo.mapper.ContractMapper;
import com.example.demo.model.BasePolicy;
import com.example.demo.service.ContractService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/policy")
public class PolicyController {

    private final ContractService contractService;

    public PolicyController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping
    public ContractDto createContract(@RequestBody CreatePolicyRequest policyRequest) {
        BasePolicy basePolicy = contractService.save(policyRequest);
        return ContractMapper.INSTANCE.toDto(basePolicy);
    }

}
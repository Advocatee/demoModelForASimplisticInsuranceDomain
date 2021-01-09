package com.example.demo.controller;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.request.CreatePolicyRequest;
import com.example.demo.mapper.ContractMapper;
import com.example.demo.model.BasePolicy;
import com.example.demo.service.PolicyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/policy")
    public ContractDto createContract(@RequestBody CreatePolicyRequest policyRequest) {
        BasePolicy basePolicy = policyService.save(policyRequest);
        return ContractMapper.INSTANCE.toDto(basePolicy);
    }



}
package com.example.demo.controller;

import com.example.demo.dto.BasePolicyDto;
import com.example.demo.dto.PolicyDto;
import com.example.demo.dto.request.CreatePolicyRequest;
import com.example.demo.mapper.PolicyMapper;
import com.example.demo.model.BasePolicy;
import com.example.demo.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/policy")
    public PolicyDto createPolicy(@RequestBody CreatePolicyRequest policyRequest) {
        BasePolicy basePolicy = policyService.save(policyRequest);
        return PolicyMapper.INSTANCE.toDto(basePolicy);
    }

    @DeleteMapping("/policy/{id}")
    public ResponseEntity<Void> deletePolicyDto(@PathVariable UUID id){
        policyService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/policy")
    public ResponseEntity<List<BasePolicyDto>> getAllPolicy(){
        return ResponseEntity.ok(PolicyMapper.INSTANCE.toDto(policyService.getAllPolicy()));
    }

    @GetMapping("/policy/{id}")
    public ResponseEntity<BasePolicyDto> getPolicyById(@PathVariable UUID id){
        return ResponseEntity.ok(PolicyMapper.INSTANCE.toBaseDto(policyService.getPolicyById(id)));
    }

}
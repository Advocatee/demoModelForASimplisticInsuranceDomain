package com.example.demo.service;

import com.example.demo.dto.request.CreatePolicyRequest;
import com.example.demo.model.BasePolicy;
import com.example.demo.model.Policy;

import java.util.List;
import java.util.UUID;

public interface PolicyService {

    Policy save(Policy policy, UUID clientId, UUID vehicleId);

    <T extends BasePolicy> T save(CreatePolicyRequest policyRequest);

    void removeById(UUID id);

    List<Policy> getAllPolicy();

    Policy getPolicyById(UUID id);

}

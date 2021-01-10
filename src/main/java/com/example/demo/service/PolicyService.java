package com.example.demo.service;

import com.example.demo.dto.request.CreatePolicyRequest;
import com.example.demo.model.BasePolicy;

import java.util.List;
import java.util.UUID;

public interface PolicyService {

    <T extends BasePolicy> T save(CreatePolicyRequest policyRequest);

    void removeById(UUID id);

    List<BasePolicy> getAllPolicy();

    BasePolicy getPolicyById(UUID id);

}

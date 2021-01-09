package com.example.demo.service;

import com.example.demo.dto.CreatePolicyRequest;
import com.example.demo.model.BasePolicy;
import com.example.demo.model.Contract;

import java.util.UUID;

public interface ContractService {

    Contract save(Contract contract, UUID clientId, UUID vehicleId);

    <T extends BasePolicy> T save(CreatePolicyRequest policyRequest);

}

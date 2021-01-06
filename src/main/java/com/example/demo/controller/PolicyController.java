package com.example.demo.controller;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.CreatePolicyRequest;
import com.example.demo.mapper.ContractMapper;
import com.example.demo.model.BasePolicy;
import com.example.demo.service.ContractService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {

    private final ContractService contractService;

    public PolicyController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping("/contract")
    public ContractDto createContract(@RequestBody CreateContractRequest contractRequest) {
        Contract contract = contractService.save(ContractMapper.INSTANCE.toModel(contractRequest)
                , contractRequest.getClientId(), contractRequest.getVehicleId());
        return ContractMapper.INSTANCE.toDto(contract);
    }

}
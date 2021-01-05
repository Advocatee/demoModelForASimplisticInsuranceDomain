package com.example.demo.service;

import com.example.demo.model.Contract;

import java.util.UUID;

public interface ContractService {

    Contract save(Contract contract, UUID clientId, UUID vehicleId);

}

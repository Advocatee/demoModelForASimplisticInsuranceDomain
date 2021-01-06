package com.example.demo.service.impl;

import com.example.demo.exception.IllegalContractArgument;
import com.example.demo.exception.VehicleNofBelongToClient;
import com.example.demo.model.Client;
import com.example.demo.model.Contract;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ClientsRepository;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ContractService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContractServiceImpl implements ContractService {

    private final VehicleRepository vehicleRepository;

    private final ClientsRepository clientsRepository;

    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository, ClientsRepository clientsRepository, VehicleRepository vehicleRepository) {
        this.contractRepository = contractRepository;
        this.clientsRepository = clientsRepository;
        this.vehicleRepository = vehicleRepository;
        this.policyRepository = policyRepository;
    }

    @Override
    public Contract save(Contract contract, UUID clientId, UUID vehicleId) {
        if (clientId == null || vehicleId == null) {
            throw new IllegalContractArgument();
        }
        Client client = clientsRepository.getOne(clientId);
        Vehicle vehicle = vehicleRepository.getOne(vehicleId);
        boolean hasBoundVehicle = false;
        for (Vehicle v : client.getVehicle()
        ) {
            if (v.getId().equals(vehicleId)) {
                hasBoundVehicle = true;
                contract.setClient(client);
                contract.setVehicle(vehicle);
                break;
            }
        }
        if (!hasBoundVehicle) {
            throw new VehicleNofBelongToClient();
        }
        return contractRepository.save(contract);
    }
}


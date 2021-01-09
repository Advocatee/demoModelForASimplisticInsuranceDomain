package com.example.demo.service.impl;

import com.example.demo.dto.request.CreatePolicyRequest;
import com.example.demo.exception.IllegalContractArgument;
import com.example.demo.exception.PropertyNullPointer;
import com.example.demo.exception.VehicleNofBelongToClient;
import com.example.demo.exception.IllegalPolicyArgument;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final VehicleRepository vehicleRepository;

    private final ClientsRepository clientsRepository;

    private final ContractRepository contractRepository;

    private final PolicyRepository policyRepository;

    private final PropertyRepository propertyRepository;

    private final PropertyPolicyRepository propertyPolicyRepository;

    public PolicyServiceImpl(ContractRepository contractRepository,
                             ClientsRepository clientsRepository,
                             VehicleRepository vehicleRepository,
                             PolicyRepository policyRepository,
                             PropertyRepository propertyRepository, PropertyPolicyRepository propertyPolicyRepository) {
        this.contractRepository = contractRepository;
        this.clientsRepository = clientsRepository;
        this.vehicleRepository = vehicleRepository;
        this.policyRepository = policyRepository;
        this.propertyRepository = propertyRepository;
        this.propertyPolicyRepository = propertyPolicyRepository;
    }

    @Override
    public Policy save(Policy policy, UUID clientId, UUID vehicleId) {
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
                policy.setClient(client);
                policy.setVehicle(vehicle);
                break;
            }
        }
        if (!hasBoundVehicle) {
            throw new VehicleNofBelongToClient();
        }
        return contractRepository.save(policy);
    }

    public <T extends BasePolicy> T save(CreatePolicyRequest policyRequest) {
        String policyType = policyRequest.getPolicyType();

        UUID clientId = policyRequest.getClientId();
        UUID vehicleId = policyRequest.getVehicleId();
        UUID propertyId = policyRequest.getPropertyId();
        Client client = clientsRepository.getOne(clientId);
        if ("vehicle".equals(policyType)) {
            VehiclePolicy vehiclePolicy = new VehiclePolicy();
            if (vehicleId == null) {
                throw new PropertyNullPointer();
            }
            Vehicle vehicle = vehicleRepository.getOne(vehicleId);
            vehiclePolicy.setClient(client);
            vehiclePolicy.setVehicle(vehicle);
            vehiclePolicy.setCoverageType(CoverageType.COLLISION);
            vehiclePolicy.setPhoneNumber(policyRequest.getPhoneNumber());
            vehiclePolicy.setDateOfInformation(policyRequest.getDateOfInformation());
            vehiclePolicy.setPolicyExpirationDate(policyRequest.getPolicyExpirationDate());
            VehiclePolicy savedVehiclePolicy = policyRepository.save(vehiclePolicy);
            return (T) savedVehiclePolicy;
        } else if ("property".equals(policyType)) {
            PropertyPolicy propertyPolicy = new PropertyPolicy();
            Property property = propertyRepository.getOne(propertyId);
            propertyPolicy.setClient(client);
            propertyPolicy.setProperty(property);
            propertyPolicy.setPhoneNumber(policyRequest.getPhoneNumber());
            propertyPolicy.setDateOfInformation(policyRequest.getDateOfInformation());
            propertyPolicy.setPolicyExpirationDate(policyRequest.getPolicyExpirationDate());
            PropertyPolicy savedPropertyPolicy = propertyPolicyRepository.save(propertyPolicy);
            return (T) savedPropertyPolicy;
        }
        throw new IllegalPolicyArgument();
    }

    @Override
    public void removeById(UUID id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Policy> getAllPolicy() {
        return null;
    }

    @Override
    public Policy getPolicyById(UUID id) {
        return null;
    }
}
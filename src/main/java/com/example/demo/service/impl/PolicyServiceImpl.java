package com.example.demo.service.impl;

import com.example.demo.dto.request.CreatePolicyRequest;
import com.example.demo.exception.*;
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


    private final PolicyRepository policyRepository;

    private final PropertyRepository propertyRepository;

    private final PropertyPolicyRepository propertyPolicyRepository;

    public PolicyServiceImpl(ClientsRepository clientsRepository,
                             VehicleRepository vehicleRepository,
                             PolicyRepository policyRepository,
                             PropertyRepository propertyRepository, PropertyPolicyRepository propertyPolicyRepository) {
        this.clientsRepository = clientsRepository;
        this.vehicleRepository = vehicleRepository;
        this.policyRepository = policyRepository;
        this.propertyRepository = propertyRepository;
        this.propertyPolicyRepository = propertyPolicyRepository;
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
                throw new VehicleNullPointer();
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
            if (propertyId == null) {
                throw new PropertyNullPointer();
            }
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
        policyRepository.deleteById(id);
    }

    @Override
    public List<BasePolicy> getAllPolicy() {
        return policyRepository.findAll();
    }

    @Override
    public BasePolicy getPolicyById(UUID id) {
        return policyRepository.getOne(id);
    }
}
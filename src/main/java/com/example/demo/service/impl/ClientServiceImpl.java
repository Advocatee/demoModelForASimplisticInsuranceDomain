package com.example.demo.service.impl;

import com.example.demo.model.Client;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ClientsRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientsRepository clientsRepository;

    private final VehicleRepository vehicleRepository;

    public ClientServiceImpl(ClientsRepository clientsRepository, VehicleRepository vehicleRepository) {
        this.clientsRepository = clientsRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Client save(Client client, UUID vehicleId) {
        Vehicle vehicle = vehicleRepository.getOne(vehicleId);
        if (vehicleId == null){
           return clientsRepository.save(client);
        } else
            client.getVehicle().add(vehicle);
           return clientsRepository.save(client);
        }
    }


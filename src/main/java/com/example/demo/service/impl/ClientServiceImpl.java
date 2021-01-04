package com.example.demo.service.impl;

import com.example.demo.exception.VehicleNotFound;
import com.example.demo.model.Client;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ClientsRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ClientService;
import org.hibernate.procedure.NoSuchParameterException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
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
        if (vehicleId != null) {
            Vehicle vehicle = vehicleRepository.getOne(vehicleId);
            client.getVehicle().add(vehicle);
            vehicle.setClient(client);
        }
        return clientsRepository.save(client);
    }

    @Override
    public void remove(UUID id) {
        clientsRepository.deleteById(id);
    }

    @Override
    public List<Client> getAllClient() {
        return clientsRepository.findAll();
    }

    @Override
    public Client getClientById(UUID id) {
        return clientsRepository.getOne(id);
    }


}



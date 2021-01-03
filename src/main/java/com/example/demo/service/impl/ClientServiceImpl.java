package com.example.demo.service.impl;

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
        Vehicle vehicle = null;
        if (vehicleId != null) {
            try {
                vehicle = vehicleRepository.getOne(vehicleId);
            } catch (EntityNotFoundException e) {
                e.getMessage();
            }
            if (vehicle != null) {
                client.getVehicle().add(vehicle);
                vehicle.setClient(client);
            } else {
                throw new NoSuchParameterException("Don't Found");
            }
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



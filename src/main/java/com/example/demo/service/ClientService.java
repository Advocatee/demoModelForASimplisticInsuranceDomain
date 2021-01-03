package com.example.demo.service;

import com.example.demo.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    Client save(Client client, UUID vehicleId);

    void remove(UUID id);

    List<Client> getAllClient();

    Client getClientById(UUID id);
}

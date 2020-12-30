package com.example.demo.service;

import com.example.demo.model.Client;

import java.util.UUID;

public interface ClientService {

    Client save(Client client, UUID vehicleId);
}

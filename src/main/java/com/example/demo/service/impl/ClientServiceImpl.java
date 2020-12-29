package com.example.demo.service.impl;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientsRepository;
import com.example.demo.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientsRepository clientsRepository;

    public ClientServiceImpl(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @Override
    public Client save(Client client) {
        return clientsRepository.save(client);
    }
}

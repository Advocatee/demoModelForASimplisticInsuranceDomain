package com.example.demo.service.impl;

import com.example.demo.model.Clients;
import com.example.demo.repository.ClientsRepository;
import com.example.demo.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsServiceImpl implements ClientsService {

    private final ClientsRepository clientsRepository;

    public ClientsServiceImpl(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @Override
    public Clients save(Clients client) {
        return clientsRepository.save(client);
    }
}

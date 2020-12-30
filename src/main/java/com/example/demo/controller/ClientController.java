package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientRequest;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client")
    public ClientDto createClient(@RequestBody CreateClientRequest clientRequest) {
        Client client = clientService.save(ClientMapper.INSTANCE.toModel(clientRequest), clientRequest.getVehicleId());
        return ClientMapper.INSTANCE.toDto(client);
    }

}
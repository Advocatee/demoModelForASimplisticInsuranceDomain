package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientRequest;
import com.example.demo.exception.VehicleNotFound;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client")
    public ResponseEntity<ClientDto> createClient(@RequestBody CreateClientRequest clientRequest) {
        try {
            Client client = clientService.save(ClientMapper.INSTANCE.toModel(clientRequest), clientRequest.getVehicleId());
            return ResponseEntity.ok(ClientMapper.INSTANCE.toDto(client));
        } catch (VehicleNotFound e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> deleteClientDto(@PathVariable UUID id) {
        clientService.remove(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/client")
    public ResponseEntity<List<ClientDto>> getAllClient() {
        return ResponseEntity.ok(ClientMapper.INSTANCE.toDto(clientService.getAllClient()));
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable UUID id) {
        return ResponseEntity.ok(ClientMapper.INSTANCE.toDto(clientService.getClientById(id)));
    }

}
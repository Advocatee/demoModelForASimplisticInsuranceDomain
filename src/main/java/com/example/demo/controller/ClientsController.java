package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientRequest;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientsController {

    private final ClientsService clientsService;

    private final EmployeeMapper employeeMapper;


    public ClientsController(ClientsService clientsService, EmployeeMapper employeeMapper) {
        this.clientsService = clientsService;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping("/client")
    public ClientDto createClient(@PathVariable CreateClientRequest clientRequest) {
        ClientDto clientDto = employeeMapper.clientDtoToClientRequest(clientRequest);
        clientsService.save(employeeMapper.clientToClientDto(clientDto));
        return clientDto;
    }

}
